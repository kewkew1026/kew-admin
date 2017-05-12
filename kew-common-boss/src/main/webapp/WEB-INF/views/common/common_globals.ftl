<#import "/spring.ftl" as spring />
<#macro basePath><#if springMacroRequestContext.getContextPath()=="/"><#else>${springMacroRequestContext.getContextPath()}</#if></#macro>
<#global ctx><@basePath/></#global>
<#global res>${ctx}/resources</#global>
<#global img>${res}/img</#global>
<#global js>${res}/js</#global>
<#global css>${res}/css</#global>
