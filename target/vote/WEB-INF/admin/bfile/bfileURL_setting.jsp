<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="pageContent">
	<c:choose>
		<c:when test="${config.configValue != null }">
			<form method="post" action="system/configEdit" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
				<div class="pageFormContent" layoutH="57">
				<input type="hidden" name="multiValue" value="0">
				<input type="hidden" name="empty" value="0">
				<input type="hidden" name="configKey" value="${bfile.id}">
				<input type="hidden" name="id" value="${config.id}">
				<div class="unit">
					<label>url:</label>
					<input name="configValue" type="text" size="30" value="${config.configValue}" />
				</div>
				<div class="unit">
					<label>备注:</label>
					<input name="description" type="text" size="30" value="${config.description}"  />
				</div>
				</div>
				<div class="formBar">
					<ul>
						<li>
							<div class="buttonActive">
								<div class="buttonContent">
									<button type="submit">保存</button>
								</div>
							</div>
						</li>
						<li>
							<div class="button">
								<div class="buttonContent">
									<button type="button" class="close">取消</button>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<form method="post" action="system/addConfig" class="pageForm required-validate" rel="" onsubmit="return iframeCallback(this, dialogAjaxDone);">
				<div class="pageFormContent" layoutH="57">
				<input type="hidden" name="multiValue" value="0">
				<input type="hidden" name="empty" value="0">
				<input type="hidden" name="configKey" value="${bfile.id}">
				<div class="unit">
					<label>url:</label>
					<input name="configValue" type="text" size="30" value="" />
				</div>
				<div class="unit">
					<label>备注:</label>
					<input name="description" type="text" size="30" value=""  />
				</div>
				</div>
				<div class="formBar">
					<ul>
						<li>
							<div class="buttonActive">
								<div class="buttonContent">
									<button type="submit">保存</button>
								</div>
							</div>
						</li>
						<li>
							<div class="button">
								<div class="buttonContent">
									<button type="button" class="close">取消</button>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</form>
		</c:otherwise>
	</c:choose>
</div>
