<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/7/31
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--分页条的开始--%>
<div id="page_nav">
    <%-- 如果是第一页则不显示上一页和首页--%>
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=1"> 首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>

    <c:choose>
        <c:when test="${requestScope.page.pageTotal <= 5}">
            <c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
                <c:if test="${requestScope.page.pageNo == i}">
                    【${i}】
                </c:if>
                <c:if test="${requestScope.page.pageNo != i}">
                    <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                </c:if>
            </c:forEach>
        </c:when>
        <%-- 情况2：总页码大于5的情况，假设一共十页--%>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <%-- 小情况1:当前页码为前三个：1，2，3的情况：页码范围是：1-5 --%>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:forEach begin="1" end="5" var="i">
                        <c:if test="${i == requestScope.page.pageNo}">
                            【${i}】
                        </c:if>
                        <c:if test="${i != requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal - 3}">
                    <c:forEach begin="${requestScope.page.pageTotal - 4}" end="${requestScope.page.pageTotal}" var="i">
                        <c:if test="${i == requestScope.page.pageNo}">
                            【${i}】
                        </c:if>
                        <c:if test="${i != requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>

                 <c:otherwise>
                <%--<c:when test="${3 < requestScope.page.pageNo && requestScope.page.pageNo < requestScope.page.pageTotal-2}">--%>
                    <c:forEach begin="${requestScope.page.pageNo -2}" end="${requestScope.page.pageNo + 2}" var="i">
                        <c:if test="${requestScope.page.pageNo == i}">
                            【${i}】
                        </c:if>
                        <c:if test="${requestScope.page.pageNo != i}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                <%--</c:when>--%>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <%-- 如果已经是最后一页，则不显示下一页和末页--%>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${empty param.pageNo ? 1 : param.pageNo}" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">
    <script type="text/javascript">

        $(function () {
            //跳到指定的页码
            $("#searchPageBtn").click(function () {
                var pageNo = $("#pn_input").val();
                //JavaScript语言中提供了一个Location地址兰对象
                //它有一个属性叫href,它可以获取浏览器地址栏中的地址
                //href属性可读可写
                // alert(location.href);
                <%--var pageTotal = ${requestScope.page.pageTotal};--%>
                <%-- 错误写法--%>
                <%--<c:if test="parseInt(${requestScope.page.pageTotal}) > parseInt(pageNo) && parseInt(pageNo) > 0)">--%>
                <%--location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo=" + pageNo;--%>
                <%--</c:if>--%>
                <%--	方式二   --%>
                if (parseInt(${requestScope.page.pageTotal}) > parseInt(pageNo) && parseInt(pageNo) > 0) {
                    location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo=" + pageNo;
                }
                <%--location.href = "${pageScope.basePath}manager/bookServlet?action=page&pageNo=" + pageNo;--%>
            });
        });
    </script>
</div>
<%--分页的结束--%>
