
//上一页方法
function lastPage() {
	var totalPage = $("#totalPage").val()
	var source = $("#source").val()
	var hpcId = $("#hpcId").val()
	var pageNo = parseInt($("#currentPage").val())
	var name = $("#queryName").val()

	if (name == null) {
		name = 0;
	}

	if (pageNo == 1) {
		$("#lastPage").css("disable","disabled");
		$("#lastPage").css("color","grey");
	} else {
		pageNo = pageNo - 1
		window.location.href = "ref?src=" + source + "&page=" + pageNo
				+ "&hpcId=" + hpcId + "&qname=" + name
	}
}
// 下一页方法
function nextPage() {

	var totalPage = $("#totalPage").val()
	var source = $("#source").val()
	var hpcId = $("#hpcId").val()
	var pageNo = parseInt($("#currentPage").val())
	var name = $("#queryName").val()

	if (name == null) {
		name = 0;
	}

	if (pageNo == parseInt(totalPage)) {
		$("#nextPage").css("disable","disabled");
		$("#nextPage").css("color","grey");
	} else {
		pageNo = pageNo + 1
		window.location.href = "ref?src=" + source + "&page=" + pageNo
				+ "&hpcId=" + hpcId + "&qname=" + name
	}

}

function queryProducts() {
	var qname = $("#qname").val()
	var pageNo = parseInt($("#currentPage").val())
	if (qname == null) {
		alert("请输入想要搜索的商品名!")
	} else {
		window.location.href = "ref?src=3&page=" + pageNo
		+ "&hpcId=0&qname=" + qname

	}

}

