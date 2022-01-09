<#noparse>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>告警列表</title>
</head>
</#noparse>
<body>
<h1>${title}</h1>
<table border="1" id="table1">
    <#list datas as data>
        <#if data?exists>
            <tr charset="UTF-8">
                <#list data as d>
                    <#if data_index==0>
                        <th> ${d}</th>
                    </#if>
                    <#if data_index!=0>
                        <#if d_index%3==2>
                            <#list d?keys as key>
                                <td >
                                    <a href="${d[key]}">${key}</a>
                                </td>
                            </#list>
                        </#if>
                        <#if d_index%3!=2>
                            <td >
                                ${d}
                            </td>
                        </#if>
                    </#if>
                </#list>
            </tr>
        </#if>
    </#list>
</table>
<script type='text/javascript' src='http://apps.bdimg.com/libs/jquery/1.9.1/jquery.min.js'></script>
<script type="text/javascript">
	//多级次动态合并表格行
	function checkArray(arr1,arr2){
		for (var i = 0; i < arr1.length; i++) {
			if (arr1[i].innerText===arr2[i].innerText) {

			 }else{
					  return false;
			}
		}
		 return true;
	}
	function dynamicMergeTableRow(tableId){
		  var tb = document.getElementById(tableId);
		  var obj1;
		  var obj2;
		  var objtemp1 = [];
		  var objtemp2 = [];
		  var rowCount = tb.rows.length;
		  console.info(rowCount);
		  var colCount = tb.rows[0].cells.length;
		  console.info(rowCount);
		  var colLength = 2;

		  //命名(表头除外)
		  for (var i = 1; i < rowCount; i++) {
			for (var j = 0; j < colCount; j++) {
			  tb.rows[i].cells[j].id = "tb_" + i.toString() + "_" + j.toString();
			}
		  }

		  //从后往前检查，进行逐列检查合并,开始列为colLength-1
		  for (var col = colLength -1; col >= 0; col--) {
			 //当col>0时有前方的单元格
			 if (col > 0) {
				//objtemp1为obj1左侧所有单元格集合，初始objtemp1及obj1均从第二行开始(tb_1_)
				for (var l = 0; l < col; l++) {
				   objtemp1[l] = document.getElementById("tb_1_" + l.toString());
				}
			 }
			 obj1 = document.getElementById("tb_1_" + col.toString());

			 //obj2为obj1下方单元格,obj1从第二行开始，则obj2从第三行开始，遍历以row=2为起始值
			 for (var row = 2; row < rowCount; row++) {
					//同obj1及objtemp1，col>0：即有前方单元格，此时有objtemp2
					if (col > 0) {
						for (var l = 0; l < col; l++) {
						   objtemp2[l] = document.getElementById("tb_" + row.toString() +"_"+ l.toString());
						}
					}
					obj2 = document.getElementById("tb_" + row.toString() +"_"+ col.toString());

					//定义完obj1/obj2/objtemp1/objtemp2后，开始合并
					//第一层判断：当obj1的值等于obj2时，即同一列的相邻单元格值相同
					if (obj1.innerText == obj2.innerText) {
						//第二层判断：obj1/obj2所在列前方还有其他列：即col>0(此步判断为单元格合并的依赖性提供支持)
						if (col > 0) {
							//第三层判断：obj1/obj2所在列前方还有其他列，且objtemp1,objtemp2值完全相同，可以合并
							if (checkArray(objtemp1,objtemp2)) {
								obj1.rowSpan++;
								obj2.parentNode.removeChild(obj2);
							}
							//第三层判断：obj1/obj2所在列前方还有其他列，且objtemp1,objtemp2值不同，不可合并，并重新对obj1/objtemp1赋值，令其等于原来的obj2/objtemp2
							else{
								obj1 = document.getElementById("tb_" + row.toString() +"_"+ col.toString());
								for (var l = 0; l < col; l++) {
									objtemp1[l] = document.getElementById("tb_" + row.toString() +"_"+ l.toString());
								}
							}
						}
						//第二层判断：obj1/obj2所在列为首列，直接合并
						else{
							obj1.rowSpan++;
							obj2.parentNode.removeChild(obj2);
						}
					}
					//第一层判断：当obj1的值不等于obj2时，即同一列的相邻单元格值不相，此时重新对obj1/objtemp1赋值，令其等于原来的obj2/objtemp2
					else{
						obj1 = document.getElementById("tb_" + row.toString() +"_"+ col.toString());
						for (var l = 0; l < col; l++) {
							objtemp1[l] = document.getElementById("tb_" + row.toString() +"_"+ l.toString());
						}
					}
			 }
			 objtemp1 = [];
			 objtemp2 = [];
		  }
	}
	dynamicMergeTableRow('table1');
 </script>
</body>
</html>