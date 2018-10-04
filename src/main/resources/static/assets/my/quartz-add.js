$(document).ready(function () {
	$("#customerQuarz").val("");
	$("#customerQuarz").cronGen({
    	direction : 'left'
	});
	reset();
});

var reset = function(){
	var quartzId = $("#quartzId").val();
	$.ajax({
        type: 'POST',
        async: false,
        url: 'quartz/getQuartz.shtml',
        data: {
        	quartzId : quartzId
        },
        success: function (data) {
        	var quartz = data.data;
        	$("#quartzId").val(quartz.quartzId);
        	$("#quartzDescription").val(quartz.quartzDescription);
        	$("#quartzCron").val(quartz.quartzCron); 
        },
        error: function () {
            alert("请求失败！请刷新页面重试");
        },
        dataType: 'json'
    });
}


$.validator.setDefaults({
	highlight: function (element) {
        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    },
    success: function (element) {
        element.closest('.form-group').removeClass('has-error').addClass('has-success');
    },
    errorElement: "span",
    errorPlacement: function (error, element) {
        if (element.is(":radio") || element.is(":checkbox")) {
            error.appendTo(element.parent().parent().parent());
        } else {
            error.appendTo(element.parent());
        }
    },
    errorClass: "help-block m-b-none",
    validClass: "help-block m-b-none"	
});
$().ready(function () {
	
    var icon = "<i class='fa fa-times-circle'></i> ";

    $("#quartzForm").validate({
    	 rules: {
    		quartzDescription: {
         		required: true,
         		maxlength: 50
         	},
         	customerQuarz: {
         		required: true
         	} 
         },
         messages: {
        	quartzDescription: {
         		required: icon + "请输入名称",
         		maxlength: icon + "名称不能超过50个字符"
         	},
         	customerQuarz: {
         		required: icon + "请输入策略"
         	} 
         },
        submitHandler:function(form){
        
        	$.post("quartz/insert.shtml", decodeURIComponent($(form).serialize(),true), function(data){
        		var result = JSON.parse(data);
    			if(result.status == "success"){
    				
    				layer.msg('添加成功',{
            			time: 2000,
            			icon: 6
            		});              		
            		setTimeout(function(){
            			location.href = "view/cron/listUI.shtml";
            		},2000);
    			}else {
    				layer.msg(result.message, {icon: 2}); 
    				
    			}
    		});
        } 
    });

});

var cancel = function(){
	location.href = "view/cron/listUI.shtml";
	
}