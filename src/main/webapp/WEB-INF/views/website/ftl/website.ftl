<#macro mactest testvalue>
    <div>${testvalue}</div>
</#macro>

<#--页面导航标签-->
<#macro navigater navList navId>
   <#if navList??>
    <ul>
        <li><a href="${base}/" <#if navId??><#if navId==0>class="menu-active"</#if></#if>>首页
            <!--[if IE 7]><!--></a><!--<![endif]-->
            <!--[if lte IE 6]><table><tr><td><![endif]--><!--[if lte IE 6]></td></tr></table></a><![endif]-->
        </li>
       <#list navList as nav>
	   <#if nav??>
           <li>
               <#if nav.childList?? && (nav.childList?size>0)>
               <a href="" <#if navId == nav.categoryId>class="menu-active"</#if>>${nav.categoryName!''}<!--[if IE 7]><!--></a><!--<![endif]--><!--[if lte IE 6]><table><tr><td><![endif]-->
               <ul><#list nav.childList as childNav><#if childNav??>
                   <li><a href="${childNav.categoryUrl!''}">${childNav.categoryName!''}</a></li></#if></#list>
               </ul>
               <#else>
               <a href="<#if nav.categoryUrl??>${nav.categoryUrl!''}</#if>" <#if navId == nav.categoryId>class="menu-active"</#if>><#if nav.categoryUrl??>${nav.categoryName!''}</#if><!--[if IE 7]><!--></a><!--<![endif]--><!--[if lte IE 6]><table><tr><td><![endif]-->
               </#if>
               <!--[if lte IE 6]></td></tr></table></a><![endif]-->
           </li>
       </#if>
       </#list>
    </ul>
   </#if>
</#macro>