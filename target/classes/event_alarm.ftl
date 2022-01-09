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
<#if text?exists>
    <#assign json=text?eval />
    <#list json as item>
        <a>${item.name}--->${item.amount}</a>
    </#list>
<#--    <#assign json=json?eval />-->
<#--    <#list json as item>-->
<#--      <p>${item.name}-&ndash;&gt;${item.amount}</p>-->
<#--    </#list>-->
</#if>
</body>
</html>