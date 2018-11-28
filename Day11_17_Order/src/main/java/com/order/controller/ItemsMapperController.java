package com.order.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.order.biz.ItemsMapperBiz;
import com.order.entity.Items;
import com.order.entity.QueryVo;
import com.order.exception.CustomException;


@Controller
@RequestMapping("items")
public class ItemsMapperController {
		@Resource(name="itemsMapperBizImpl")
		private ItemsMapperBiz imb;
		
	
		
		@RequestMapping("selectAll")
		public ModelAndView selectAllItems(){
			List<Items> itemList = imb.selectAllItems();
			ModelAndView mv = new ModelAndView("item");
			mv.addObject("itemList",itemList);
			return mv;
		}
		@RequestMapping("doedit")
		public ModelAndView updateByPrimaryKey(HttpServletRequest request){
			String strid = request.getParameter("id");
			Integer id = null;
			// 如果id有值则转换成int类型
			if (strid != null && !"".equals(strid)) {
				id = Integer.valueOf(strid);
			} else {
				// 出错
				return null;
			}
			Items item = imb.selectByPrimaryKey(id);
			ModelAndView mv = new ModelAndView("doedits");
			mv.addObject("item",item);
			return mv;
		}
		@RequestMapping("edit")
		public String edit(Items items,HttpServletResponse response,MultipartFile pictureFile) throws IOException {
			PrintWriter out = response.getWriter();
			// 进行图片上传
			if (pictureFile != null && pictureFile.getOriginalFilename() != null
					&& pictureFile.getOriginalFilename().length() > 0) {
				// 图片上传成功后，将图片的地址写到数据库
				String filePath = "E:\\JavaEE高级开发\\Upload\\";
				// 上传文件原始名称
				String originalFilename = pictureFile.getOriginalFilename();
				// 新的图片名称
				String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
				// 新文件
				File file = new java.io.File(filePath + newFileName);

				// 将内存中的文件写入磁盘
				pictureFile.transferTo(file);

				// 图片上传成功，将新图片地址写入数据库
				items.setPic(newFileName);
			}
			System.out.println(items.getPic());
			int flag=imb.updateByPrimaryKeySelective(items);
			if(flag>=1) {//修改成功
				return "redirect:selectAll.action";
			}else {
				out.write("<script>alert('修改失败！');</script>");
				return null;
			}
		}
		@RequestMapping("dodel")
		public String delItem(HttpServletRequest request,HttpServletResponse response) throws IOException {
			PrintWriter out = response.getWriter();
			String strid = request.getParameter("id");
			Integer id = null;
			// 如果id有值则转换成int类型
			if (strid != null && !"".equals(strid)) {
				id = Integer.valueOf(strid);
			} else {
				// 出错
				return null;
			}
			int flag=imb.deleteByPrimaryKey(id);
			if(flag>=1) {//修改成功
				return "redirect:selectAll.action";
			}else {
				out.write("<script>alert('修改失败！');</script>");
				return null;
			}
		}
		@RequestMapping("doAdd")
		public String add() {
				return "doAdd";
		}
		@RequestMapping("add")
		public String add(QueryVo queryVo, MultipartFile pictureFile,HttpServletResponse response) throws IOException  {
			if (pictureFile != null && pictureFile.getOriginalFilename() != null
					&& pictureFile.getOriginalFilename().length() > 0) {
				// 图片上传成功后，将图片的地址写到数据库
				String filePath = "E:\\JavaEE高级开发\\Upload\\";
				// 上传文件原始名称
				String originalFilename = pictureFile.getOriginalFilename();
				// 给原始文件重新命名 +源文件的后缀
				String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
				// 抽象文件
				File file = new File(filePath + newFileName);
				// 将内存中的文件写入磁盘
				pictureFile.transferTo(file);
				// 将新文件的路径 保存到items对象
				queryVo.getItems().setPic(newFileName);
			}
			// 执行添加功能
			int flag = imb.insert(queryVo.getItems());
			if (flag>=1) {
				return "redirect:selectAll.action";
			} else {
				response.getWriter().println("<script>alert('删除失败！');</script>");
				return null;
			}

		}
		@RequestMapping("delmore")
		public String queryItem(QueryVo queryVo, String[] ids,HttpServletResponse response) throws IOException {
			System.out.println("-------------------");
			System.out.println(Arrays.toString(ids));
			boolean flag = imb.delItems(ids);
			if (flag) {
				return "redirect:selectAll.action";
			} else {
				response.getWriter().println("<script>alert('删除失败！');</script>");
				return null;
			}

		}
		@RequestMapping("dobacthEdit.action")
		public ModelAndView dobatchEdit() {
			List<Items> list = imb.selectAllItems();
			ModelAndView mv = new ModelAndView("dobacthEdit");
			mv.addObject("itemList", list);
			return mv;
		}
		@RequestMapping("batchEdit")
		public String batchEdit(QueryVo queryVo, String[] ids, HttpServletResponse response) throws IOException {
			if(ids.length>0) {
				boolean flag = imb.updateItems(queryVo,ids );
				if (flag) {
					return "redirect:selectAll.action";
				} else {
					response.getWriter().println("<script>alert('修改失败！');</script>");
					return null;
				}
			}else {
				response.getWriter().println("<script>alert('修改失败！');</script>");
				return null;
			}
			
		}
		@RequestMapping( "dodetails/{id}")
		public @ResponseBody Items dodetails(@PathVariable("id") Integer id) throws CustomException, IOException {
			Items item = imb.selectByPrimaryKey(id);
			if (item == null) {
				throw new CustomException("商品信息不存在！");
			}
			return item;
		}
		
//		// 动态页面跳转
//		@RequestMapping("/{forName}")
//		public String dynaicPage(@PathVariable String forName) {
//			return forName;
//		}
		
}
