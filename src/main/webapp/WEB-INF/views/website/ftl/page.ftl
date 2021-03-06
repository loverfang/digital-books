﻿<#-- 分页（Pager对象、链接URL、参数Map、最大页码显示数） -->
<#macro pager pager baseUrl parameterMap = {} maxShowPageCount = 4 showTxtNav = 1>
	<#local pageNumber = pager.currPage />
	<#local pageSize = pager.pageSize /> 
	<#local pageCount = pager.totalPage /> <#--总页数-->
	<#local parameter = "" />

	<#local parameter = parameter + "&pageSize=" + pageSize />

	<#list parameterMap?keys as key>
		<#if parameterMap[key]??>
			<#local parameter = parameter + "&" + key + "=" + parameterMap[key] />
		</#if>
	</#list>

	<#if baseUrl?contains("?")>
		<#local baseUrl = baseUrl + "&" />
	<#else>
		<#local baseUrl = baseUrl + "?" />
	</#if>

	<#local firstPageUrl = baseUrl + "pageNo=1" + parameter />
	<#local lastPageUrl = baseUrl + "pageNo=" + pageCount + parameter />
	<#local prePageUrl = baseUrl + "pageNo=" + (pageNumber - 1) + parameter />
	<#local nextPageUrl = baseUrl + "pageNo=" + (pageNumber + 1) + parameter />


	<#if maxShowPageCount <= 0>
		<#local maxShowPageCount = 4>
	</#if>

	
	<#local segment = ((pageNumber - 1) / maxShowPageCount)?int + 1 />

	<#local startPageNumber = ( (segment - 1) * maxShowPageCount +1 ) - 1/>
	<#local endPageNumber = (segment * maxShowPageCount) + 1/>

	
	<#if (startPageNumber < 1)>
		<#local startPageNumber = 1 />
	</#if>

	<#if (endPageNumber > pageCount)>
		<#local endPageNumber = pageCount />
	</#if>


	<#if (pageCount > 1)>
		<#--
		<li class="pageInfo">
			共 ${segment} 页
		</li>
		-->
			
		<#-- 上一页 -->
		<#if (pageNumber > 1)>
			<a class="first" href="${prePageUrl}"><i></i> <#if showTxtNav=1>上一页</#if></a>
		<#else>
			<a class="first"><i></i><#if showTxtNav=1>上一页</#if></a>
		</#if>
			
			
		<#if (startPageNumber > 1)>
			<a href="${baseUrl + "pageNo=" + 1 + parameter}">1</a>
			<#-- <a href="${baseUrl + "pageNumber=" + (pageNumber - 2) + parameter}">...</a> -->
			<a>...</a>
		</#if>

			
		<#list startPageNumber .. endPageNumber as index>
			
			<#if pageNumber != index>
				<a href="${baseUrl + "pageNo=" + index + parameter}">${index}</a>
			<#else>
				<a class="on">${index}</a>
			</#if>

		</#list>
			
		<#if (endPageNumber < pageCount)>
			<#-- <a href="${baseUrl + "pageNumber=" + (pageNumber + 2) + parameter}">...</a> -->
			<a>...</a>
			<a href="${baseUrl + "pageNo=" + pageCount + parameter}">${pageCount}</a>
		</#if>


		<#-- 下一页 -->
		<#if (pageNumber < pageCount)>
			<a class="last" href="${nextPageUrl}"><#if showTxtNav=1>下一页</#if><i></i></a>
		<#else>
			<a class="last"><#if showTxtNav=1>下一页</#if><i></i></a>
		</#if>
			

	</#if>

</#macro>