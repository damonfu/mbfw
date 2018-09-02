<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <base href="<%=basePath%>">
        <meta charset="utf-8"/>
        <title></title>
        <meta name="description" content="overview & stats"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link href="static/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="static/css/bootstrap-responsive.min.css" rel="stylesheet"/>
        <link rel="stylesheet" href="static/css/font-awesome.min.css"/>
        <!-- 下拉框 -->
        <link rel="stylesheet" href="static/css/chosen.css"/>
        <link rel="stylesheet" href="static/css/ace.min.css"/>
        <link rel="stylesheet" href="static/css/ace-responsive.min.css"/>
        <link rel="stylesheet" href="static/css/ace-skins.min.css"/>
        <script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
        <!--提示框-->
        <script type="text/javascript" src="static/js/jquery.tips.js"></script>

        <script type="text/javascript">
            $(top.hangge());

            //保存
            function save() {
                if($("#name").val()==""){
                    $("#name").focus();
                    return false;
                }
                if($("#index").val()==""){
                    $("#index").focus();
                    return false;
                }
                if($("#prev").val()==""){
                    $("#prev").focus();
                    return false;
                }
                if($("#img").val()==""){
                    $("#img").focus();
                    return false;
                }
                if($("#size").val()==""){
                    $("#size").focus();
                    return false;
                }
                $("#userForm").submit();
                $("#zhongxin").hide();
                $("#zhongxin2").show();
            }

        </script>
    </head>

    <body>
        <form action="qrman/${msg }.do" name="userForm" id="userForm" method="post">
            <input type="hidden" name="_ID" id="_id" value="${pd._id }"/>
            <div id="zhongxin">
                <table>
                    <tr>
                        <td><input type="text" name="NAME" id="name" value="${pd.name }" maxlength="50" placeholder="这里输入名称"
                                   title="模板名称"/></td>
                        <td><input type="text" name="INDEX" id="index" value="${pd.index }" maxlength="50" placeholder="这里输入索引"
                                   title="索引"/></td>
                        <td><input type="number" name="SIZE" id="size" value="${pd.size }" min="200" max="1000" placeholder="这里输入大小"
                                   title="大小"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="PREV" id="prev" value="${pd.prev }" maxlength="400" placeholder="这里输入预览图"
                                   title="预览图"/></td>
                        <td><input type="text" name="IMG" id="img" value="${pd.img }" maxlength="400" placeholder="这里输入模板图片"
                                   title="模板图片"/></td>
                        <td><input type="text" name="LOGO" id="logo" value="${pd.logo }" maxlength="400" placeholder="这里输入LOGO"
                                   title="LOGO"/></td>
                    </tr>
                    <tr>
                        <td><input type="number" name="X" id="x" value="${"add".equals(msg) ? 0 : pd.x }" min="0" placeholder="这里输入X轴坐标"
                                   title="X轴坐标"/></td>
                        <td><input type="number" name="Y" id="y" value="${"add".equals(msg) ? 0 :pd.y }" min="0" placeholder="这里输入Y轴坐标"
                                   title="Y轴坐标"/></td>
                        <td><input type="number" name="ROTATE" id="rotate" value="${"add".equals(msg) ? 0 :pd.rotate }" max="360" placeholder="这里输入旋转角度"
                                   title="角度"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="LEFTEYESTYLE" id="lefteyestyle" value="${pd.lefteyestyle }" maxlength="10" placeholder="这里输入左码眼样式"
                                   title="左码眼样式"/></td>
                        <td><input type="text" name="LEFTEYEOUTCOLOR" id="lefteyeoutcolor" value="${pd.lefteyeoutcolor }" maxlength="10" placeholder="这里输入左外眼颜色"
                                   title="左外眼颜色"/></td>
                        <td><input type="text" name="LEFTEYEINCOLOR" id="lefteyeincolor" value="${pd.lefteyeincolor }" maxlength="10" placeholder="这里输入左内眼颜色"
                                   title="左内眼颜色"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="RIGHTEYESTYLE" id="righteyestyle" value="${pd.righteyestyle }" maxlength="10" placeholder="这里输入右码眼样式"
                                   title="右码眼样式"/></td>
                        <td><input type="text" name="RIGHTEYEOUTCOLOR" id="righteyeoutcolor" value="${pd.righteyeoutcolor }" maxlength="10" placeholder="这里输入右外眼颜色"
                                   title="右外眼颜色"/></td>
                        <td><input type="text" name="RIGHTEYEINCOLOR" id="righteyeincolor" value="${pd.righteyeincolor }" maxlength="10" placeholder="这里输入右内眼颜色"
                                   title="右内眼颜色"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="BOTTOMEYESTYLE" id="bottomeyestyle" value="${pd.bottomeyestyle }" maxlength="10" placeholder="这里输入下码眼样式"
                                   title="下码眼样式"/></td>
                        <td><input type="text" name="BOTTOMEYEOUTCOLOR" id="bottomeyeoutcolor" value="${pd.bottomeyeoutcolor }" maxlength="10" placeholder="这里输入下外眼颜色"
                                   title="下外眼颜色"/></td>
                        <td><input type="text" name="BOTTOMEYEINCOLOR" id="bottomeyeincolor" value="${pd.bottomeyeincolor }" maxlength="10" placeholder="这里输入下内眼颜色"
                                   title="下内眼颜色"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="FRAMESTYLE" id="framestyle" value="${pd.framestyle }" maxlength="10" placeholder="这里输入边框样式"
                                   title="边框样式"/></td>
                        <td><input type="text" name="FRAMECOLOR" id="framecolor" value="${pd.framecolor }" maxlength="10" placeholder="这里输入边框颜色"
                                   title="边框颜色"/></td>
                        <td><input type="number" name="FRAMESIZE" id="framesize" value="${"add".equals(msg) ? 0 : pd.framesize }" min="0" placeholder="这里输入边框大小"
                                   title="边框大小"/></td>
                    </tr>
                    <tr>
                        <td><input type="number" name="FRAMEOUTSIZE" id="frameoutsize" value="${"add".equals(msg) ? 0 : pd.frameoutsize }" min="0" placeholder="这里输入边框外边距"
                                   title="边框外边距"/></td>
                        <td><input type="number" name="FRAMEINSIZE" id="frameinsize" value="${"add".equals(msg) ? 0 : pd.frameinsize }" min="0" placeholder="这里输入边框内边距"
                                   title="边框内边距"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="FORECOLOR" id="forecolor" value="${pd.forecolor }" maxlength="10" placeholder="这里输入前景色"
                                   title="前景色"/></td>
                        <td><input type="text" name="BACKCOLOR" id="backcolor" value="${pd.backcolor }" maxlength="10" placeholder="这里输入背景色"
                                   title="背景色"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="QRSTYLE" id="qrstyle" value="${pd.qrstyle }" maxlength="10" placeholder="这里输入样式"
                                   title="样式"/></td>
                        <td><input type="text" name="STYLEIMG" id="styleimg" value="${pd.styleimg }" maxlength="10" placeholder="这里输入样式图片"
                                   title="样式图片"/></td>
                    </tr>
                    <tr>
                        <td style="text-align: center;">
                            <a class="btn btn-mini btn-primary" onclick="save();">保存</a>
                            <a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
                        </td>
                    </tr>
                </table>
            </div>

            <div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><img
                    src="static/images/jiazai.gif"/><br/><h4 class="lighter block green"></h4></div>

        </form>

        <!-- 引入 -->
        <script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
        <script src="static/js/bootstrap.min.js"></script>
        <script src="static/js/ace-elements.min.js"></script>
        <script src="static/js/ace.min.js"></script>
        <script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->

    </body>
</html>