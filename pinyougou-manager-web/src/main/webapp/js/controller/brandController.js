//定义控制器
app.controller("brandController", function($scope, $http, brandService){
	//读取列表数据，绑定到对应的表达式中
	$scope.findAll=function(){
		brandService.findAll().success(
			function(resp){
				$scope.list = resp;
			}
		
		)
	}
	
	
	$scope.reloadList = function(){
		//$scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
		$scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
	}
	
	
	
	$scope.paginationConf = {
			 currentPage: 1,
			 totalItems: 10,
			 itemsPerPage: 10,
			 perPageOptions: [10, 20, 30, 40, 50],
			 onChange: function(){
			        	 $scope.reloadList();//重新加载
			 }
	}; 
	
	//分页
	$scope.findPage=function(page,size){
		brandService.findPage().success(
			function(rs){
				$scope.list=rs.rows;
				//更新总记录
				$scope.paginationConf.totalItems = rs.total;
			}		
		)
	}
	
	//添加
	$scope.add=function(){
		var object = null;
		if($scope.entity.id != null){
			object = brandService.update($scope.entity);
		}else{
			object = brandService.add($scope.entity);
		}
		
		object.success(
			function(bobo){
				if(bobo.success){
					console.log(bobo.message)
					$scope.reloadList();
				} else {
					alert(bobo.message);
				}
			}		
		)
	}
	
	//根据id查询，做回显数据
	$scope.findOne = function(id){
		brandService.findOne(id).success(
			function(response){
				$scope.entity = response;
			}		
		
		)
	}
	
	/* 
		1.组装选中的id
		2.调用后台的删除方法，把ids穿过去，执行删除操作
	*/
	//组装选中id
	$scope.selectIds=[];
	//用户勾选的复选框
	//$event 表示 源，相当于把input本身整个传递过来
	$scope.selection=function($event,id){
		if($event.target.checked){//如果是被选中,则增加到数组
			$scope.selectIds.push(id);			
		}else{
			var idx = $scope.selectIds.indexOf(id);
		    $scope.selectIds.splice(idx, 1);//删除 
		}
	}
	
	//批量删除 
	$scope.dele=function(){
		brandService.dele($scope.selectIds).success(
			function(response) {
				if(response.success){
					$scope.reloadList();
				}
		})
	}

	$scope.searchEntity={};
	$scope.search=function(page,size){
		brandService.search(page,size,$scope.searchEntity).success(
			function(resp){
				$scope.list=resp.rows;
				$scope.paginationConf.totalItems=resp.total;
			}
		)
	}
	
	
})