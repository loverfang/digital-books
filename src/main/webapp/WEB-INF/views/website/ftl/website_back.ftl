<#macro mactest testvalue>
    <div>${testvalue}</div>
</#macro>

<#--页面导航标签-->
<#macro navigater navList navId>
   <#if navList??>
    <ul class="nav movedx" style="position: relative;">
       <li class="navitem"><a <#if navId??><#if navId==0>class="active"</#if></#if> href="/">首页</a></li>
       <#list navList as nav>
	   <#if nav??>
            <li class="navitem">
              <a <#if nav.isLeaf==1>href="/${nav.channelPath}/${nav.channelId}/index.html"<#else>href="javascript:;"</#if> <#if navId == nav.channelId>class="active"</#if> >${nav.channelName!''}</a>
              <#if nav.childChannel??><#if (nav.childChannel?size>0)>
              <ul class="subnav"><#list nav.childChannel as childNav><#if childNav??>
                <li><a href="/${nav.channelPath}/${childNav.channelId}/index.html">${childNav.channelName!''}</a></li></#if></#list>
              </ul>
              </#if></#if>
            </li>
       </#if>
       </#list>
    </ul>
   </#if>
</#macro>


<#--footer 标签-->
<#macro footer navList>
    <#if navList??><#list navList as nav>
    <#if nav??><#if nav_has_next>
    <dl>
      <dt>${nav.channelName}<i></i></dt>
      <#if nav.childChannel??><#list nav.childChannel as childNav><#if childNav??>
      <dd><a href="/${nav.channelPath}/${childNav.channelId}/index.html">${childNav.channelName!''}</a></dd></#if></#list></#if>
    </dl>
    </#if>
    </#if></#list></#if>
</#macro>



<#--mobile 导航标签-->
<#macro mobilenavigater navList>
    <#if navList??>
    <ul>
        <li><a href="/">网站首页</a></li>
        <#list navList as nav> <#if nav??>
        <li> 
            <a <#if nav.childChannel??>
                <#if (nav.childChannel?size>0)>href="javascript:;"<#else>href="/${nav.channelPath!''}/${nav.channelId!''}/index.html"1</#if>
            <#else>
                  href="/${nav.channelPath!''}/${nav.channelId!''}/index.html"2
            </#if>>${nav.channelName!''}</a>
            <#if nav.childChannel??><#if (nav.childChannel?size>0)>
                <ul>
                <#list nav.childChannel as childNav><#if childNav??>
	            <li>
	            <#-- 二级导航 -->
	            <a href="/${nav.channelPath!''}/${childNav.channelId!''}/index.html">${childNav.channelName!''}</a>
	            <#-- 三级导航 -->
	            <#if childNav.childChannel??><#if (childNav.childChannel?size>0)>
	            <ul>
	                <#list childNav.childChannel as sunNav><#if sunNav??>
	                <li><a href="/${sunNav.channelPath!''}/${sunNav.channelId!''}/index.html">${sunNav.channelName!''}</a></li>
	                </#if></#list>
	            </ul>
	            </#if></#if> 
	            </li>
               </#if></#list>
               </ul>
            </#if></#if>
        </li>
        </#if></#list>
    </ul>
    </#if>

</#macro>