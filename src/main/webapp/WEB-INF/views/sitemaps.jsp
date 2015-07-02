<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="<spring:url value="/res/libs/semantic-ui/dist/semantic.min.css" />"/>
    <link rel="stylesheet" href="<spring:url value="/res/assets/css/drawSiteMap.css" />" />

    <link rel="stylesheet" type='text/css' media='all' href="<spring:url value="/res/libs/angular-loading-bar/build/loading-bar.min.css" />" />
    
    <script type="text/javascript" src="<spring:url value="/res/libs/jquery/dist/jquery.min.js" />" ></script>
    
    
<title>Crawler-SiteMap</title>
</head>
<body >

	<div ng-app="crawlerViewer" ng-controller="crawlerViewerCtrl" id="windowDiv" class="ui center aligned segment">
        
	    <div ng-controller="sitemapCtrl" >
            <select ng-model="selectedRoot" ng-options="root.name for root in roots" ng-change="getSiteMap(selectedRoot)" class="ui gender dropdown">  
	            <option value="">-- 請選擇 --</option>  
	        </select>
		         
		    <div id="tree-container"></div>
	    </div>
	  
	    <div class="ui horizontal divider">then view data</div>
	    
	    
	    
	    <!-- view data div -->
	    <div ng-controller="forumViewCtrl" class="ui stackable grid segment">
	    
	    
            <div class="four wide column">
                <div>
                
                 
		        
		            <div class="ui secondary pointing vertical demo menu">
		                  <a class="item" target="_blank" 
		                      ng-repeat="forum in forums | orderBy:'name'" ng-class="{'active': forum.id==selectedForum.id}" 
		                      ng-click="clickForum(forum)">
		                      {{forum.name}} ({{forum.postSize}})
		                  </a>
		                  
		             </div>
	                
	            </div>
	            
	            
	        </div>                

            <div class="twelve wide column" >
            
            
	            <select ng-model="selectedPost" ng-options="post.title for post in posts | orderBy:'-postTime'" ng-change="getPostData(selectedPost)" class="ui gender dropdown">  
	                <option value="">-- 請選擇 --</option>  
	            </select>
	                 
	            <textarea style="height:800px; width:100%">{{formatedPostData}}</textarea>
                
            </div>
        </div>
	  
	  
        <div class="ui horizontal divider">then get data</div>
        TEST
        
    </div>
    

    
    
    <script type="text/javascript">
	   // $('.gender.dropdown').dropdown('setting', 'transition', 'vertical flip');
	   
        //for menu ui active
	    $(document).ready(function(){
	    	$('.menu .item').on('click', function() {
	    	    $(this).addClass('active')
                .closest('.ui .menu').find('.item').not($(this)).removeClass('active');
    	    });
	    });
	    
    </script>

    <script type="text/javascript" src="<spring:url value="/res/libs/angular/angular.min.js" />"></script>
    <script type="text/javascript" src="<spring:url value="/res/libs/angular-resource/angular-resource.min.js" />"></script>
    <script type="text/javascript" src="<spring:url value="/res/libs/d3/d3.min.js" />"></script>
    
    <script type='text/javascript' src="<spring:url value="/res/libs/angular-loading-bar/build/loading-bar.min.js" />" ></script>
                                       
    <!-- customized -->               
    <script type="text/javascript" src="<spring:url value="/res/app/global.js" />"></script>
    <script type="text/javascript" src="<spring:url value="/res/app/drawSiteMap.js" />"></script>
    <script type="text/javascript" src="<spring:url value="/res/app/app.js" />"></script>
    <script type="text/javascript" src="<spring:url value="/res/app/controllers.js" />"></script>

    
    <!-- 
    <script type="text/javascript" src="app/services.js"></script>
    <script type="text/javascript" src="app/filters.js"></script>
     -->
     <script type="text/javascript" src="libs/showdown/compressed/showdown.js"></script>
</body>
</html>