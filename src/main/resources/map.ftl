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
<#if map?exists>
    <#list map?keys as key>
        <h2>  ${key}  </h2>
        <#assign childmap = map[key]>
        <#list childmap?keys as key>
            <a href="${childmap[key]}">${key}</a>
            <p/>
        </#list>
    </#list>
</#if>
</body>
</html>