# 融助手接口文档（Rongzi Assistant Api）


## 0. 环境说明
* 测试环境地址:http://10.40.3.230:8077
* 开发环境地址:http://10.40.3.110:8077


## 1. 统一请求、响应的参数和格式

### 请求（request）
* querystring参数使用kv键值对格式。
* 请求体参数统一使用json格式，即content-type:application/json  

### 响应（response）
* 响应体统一使用json格式。 

#### 响应参数
|Key|Value|类型|说明|
|---|---|---|---|
|code|返回代码|int|0:成功 其他:异常| 
|msg |提示信息|String|调用成功或失败的描述| 
|data|业务数据|Object|返回数据| 


## 2. token 说明

### 从用户登录获取到用户及token信息  
示例如下:  
```
{
    "code": 0,
    "msg": "",
    "data": {
        "userInfo": {
            "accountName": "liuchao",
            "cityCode": "SUZHOU",
            "cityName": "",
            "dprCode": "",
            "dprName": "",
            "empCode": "AA1611",
            "empName": "刘超[AA1611]",
            "roleCode": "",
            "roleName": ""
        },
        "token":"Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBQTE2MTEiLCJkYXRhIjp7ImFjY291bnROYW1lIjoibGl1Y2hhbyIsImVtcENvZGUiOiJBQTE2MTEiLCJlbXBOYW1lIjoi5YiY6LaFW0FBMTYxMV0iLCJjaXR5Q29kZSI6IlNVWkhPVSIsImNpdHlOYW1lIjpudWxsLCJkcHJDb2RlIjpudWxsLCJkcHJOYW1lIjpudWxsLCJyb2xlQ29kZSI6bnVsbCwicm9sZU5hbWUiOm51bGx9LCJleHAiOjE1MzYxMTMwOTksImlhdCI6MTUzNTUwODI5OX0.OoLpECeSs8oAnWiZ9xc7E81UP_hTSGm7Wy1J_yjM43lXbu8dvT7MyhaW-1_FH50oX1kIM-7SPvmsF0hXzvy2gw"
    }
}
```

### 请求需将token带入请求头 
示例如下:  
```
GET /resource HTTP/1.1
Host: server.example.com
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBQTE2MTEiLCJkYXRhIjp7ImFjY291bnROYW1lIjoibGl1Y2hhbyIsImVtcENvZGUiOiJBQTE2MTEiLCJlbXBOYW1lIjoi5YiY6LaFW0FBMTYxMV0iLCJjaXR5Q29kZSI6IlNVWkhPVSIsImNpdHlOYW1lIjpudWxsLCJkcHJDb2RlIjpudWxsLCJkcHJOYW1lIjpudWxsLCJyb2xlQ29kZSI6bnVsbCwicm9sZU5hbWUiOm51bGx9LCJleHAiOjE1MzYxMTMwOTksImlhdCI6MTUzNTUwODI5OX0.OoLpECeSs8oAnWiZ9xc7E81UP_hTSGm7Wy1J_yjM43lXbu8dvT7MyhaW-1_FH50oX1kIM-7SPvmsF0hXzvy2gw
```

PS:  
这里我们采用比较通用的Http Authorization + Bearer Token的形式。  

Bearer Token 的格式:
> Bearer XXXXXXXX  

可以参考这篇文章:[OAuth 2.0: Bearer Token Usage](https://www.cnblogs.com/XiongMaoMengNan/p/6785155.html) 

### token校验
当token校验失败，会收到如下响应内容:

    {
        code:500,
        msg:"不合法的token"
    }


## 3. 用户登录

> POST /api/account/login   

### 参数

入参说明：

|Key|Value|类型|说明|
|---|---|---|---|
|username|销售工号|String|暂定为4位工号| 
|password|密码|String|与融管系统通用| 

入参示例  

    {
        "username":"1611",
        "password":"e10adc3949ba59abbe56e057f20f883e"
    }


### 响应

响应说明：

|Key|Value|类型|说明|
|---|---|---|---|
|accountName|销售工号|String|---|
|accountName|账号名称|String|---|
|empCode|用户编号|String|---|
|empName|用户姓名|String|---|
|cityCode|城市编号|String|---|
|cityName|城市名称|String|---|
|dprCode|部门编号|String|---|	
|dprName|部门名称|String|---|
|roleCode|职位编号|String|---|			
|roleName|职位名称|String|---|
|empWorkMobile|销售手机|String|---|
|empWechatId|销售微信ID|String|---|

响应示例

登录成功示例:

    {
        "code": 0,
        "data": {
            "userInfo": {
                "accountName": "liuchao",
                "cityCode": "SUZHOU",
                "cityName": "苏州市",
                "dprCode": "",
                "dprName": "",
                "empCode": "AA1611",
                "empName": "刘超[AA1611]",
                "empWechatId": "wxid_slhv0lqkbac222",
                "empWorkMobile": "18516431436",
                "roleCode": "",
                "roleName": ""
            },
            "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBQTE2MTEiLCJkYXRhIjp7ImFjY291bnROYW1lIjoibGl1Y2hhbyIsImVtcENvZGUiOiJBQTE2MTEiLCJlbXBOYW1lIjoi5YiY6LaFW0FBMTYxMV0iLCJjaXR5Q29kZSI6IlNVWkhPVSIsImNpdHlOYW1lIjoi6IuP5bee5biCIiwiZHByQ29kZSI6bnVsbCwiZHByTmFtZSI6bnVsbCwicm9sZUNvZGUiOm51bGwsInJvbGVOYW1lIjpudWxsLCJlbXBXb3JrTW9iaWxlIjoiMTg1MTY0MzE0MzYiLCJlbXBXZWNoYXRJZCI6Ind4aWRfc2xodjBscWtiYWMyMjIifSwiZXhwIjoxNTY4ODAyNTIzLCJpYXQiOjE1MzcyNjY1MjN9.1FugIsS1rgqEhCbw60gzxy_nzwPTkeQLOZ9kKjkfg_eYrocpJv5ul0zRLEPQWwnbRd6izL3PSQ8I-vycdyJD-Q"
        },
        "msg": "操作成功"
    }                                                            

登录失败示例:

    {
        code:1，
        msg:"用户名或密码错误"
    }


## 4. 查询客户列表

> POST /api/customer/list  

### 参数

入参说明：

|Key|Value|类型|说明|
|---|---|---|---|
|customerExeStatus|客户进程|int|-1:全部 1:有需求 2:有意向 3:已来访 4:已签约 5:已成交（包含外包和会员）|
|empCode|销售工号|String|---|
|pageSize|每页记录行数|String|---|
|pageIndex|第几页|String|从1开始|
|refreshWX|是否更新微信好友|String|1:更新 0:不更新（已弃用）|

注意:   

1. customerExeStatus 为 -1，代表查询全部进程的客户；<br>
   customerExeStatus 为 5，代表查询全部已成交的客户，包括了外包和会员两种成交客户。<br>
   PS:数据表中存储的字典 5:外包 6:会员        
2. 目前更新微信好友功能取消，refreshWX参数忽略，传递0和传递1是一样的效果。  

入参示例:

    {
        "customerExeStatus": 1,
        "pageSize": 10,
        "pageIndex": 1,
        "empCode": "AA1611"
    }

### 响应

响应说明：    

返回Customer列表

|Key|Value|类型|说明|
|---|---|---|---|
|name       |客户姓名|String|   |
|hasCars    |是否有车产|int|1:有 2:无|
|hasPolicy  |是否有担保|int|1:有 2:无|
|salary     |月打卡工资|Double| |
|hasHouse   |是否有房产|int|1:有 2:无|
|IsSecuityOrFund|是否社保公积金|int|1:无社保无公积金<br/>2:有社保有公积金<br/>4:有社保无公积金<br/>8:无社保有公积金|
|job        |工作身份|String|   |
|rqrDuration|借款期限|int|  |
|rqrAmount  |借款额度|int|  |
|paymentDate|用款时间|Date| |
|workPlace  |工作城市|String|   |
|comment    |备注|String|   |
|exeStatus  |客户进程|int|1:有需求<br/>2:有意向<br/>3:已来访<br/>4:已签约<br/>5:外包成交<br/>6:会员成交<br/>(5和6都是已成交）|
|customerCode|客户编号|String|  |
|mobile     |客户手机号码|String|   |
|contactStatus|拨打状态|int|0:未拨打<br/>1:已接通<br/>2:未接通|
|wechatFriendStatus|微信好友关系状态|int|1:非微信好友<br/>2:微信号不存在(暂不用)<br/>3:微信好友申请中(暂不用)<br/>4:微信好友申请已过期(暂不用)<br/>5:拒绝添加好友(暂不用)<br/>6:已经是微信好友|

响应示例:

    {
        "code": 0,
        "data": {
            "total": "72",
            "rows": [
                {
                    "wechatFriendStatus": 3,
                    "customerWechatId": "",
                    "mobile": "13472764344",
                    "rqrAmount": 2500,
                    "customerCode": "AAC13031400024",
                    "salary": 5000,
                    "exeStatus": 1,
                    "hasPolicy": 1,
                    "contactStatus": 2,
                    "hasHouse": 2,
                    "name": "AAC13031400024",
                    "comment": "",
                    "hasCars": 1,
                    "job": "企业主",
                    "paymentDate": "2018-08-28 14:49:20",
                    "rqrDuration": 12,
                    "isSecuityOrFund": 1,
                    "workPlace": "苏州市"
                },
                {
                    "wechatFriendStatus": 3,
                    "customerWechatId": "",
                    "mobile": "15051711562",
                    "rqrAmount": 2,
                    "customerCode": "AAC13040300071",
                    "salary": 0,
                    "exeStatus": 1,
                    "hasPolicy": 0,
                    "contactStatus": 2,
                    "hasHouse": 2,
                    "name": "AAC13040300071",
                    "comment": "下周一联系212344561234",
                    "hasCars": 2,
                    "job": "企业主",
                    "paymentDate": "2018-03-08 00:00:00",
                    "rqrDuration": 0,
                    "isSecuityOrFund": 0,
                    "workPlace": "苏州市"
                },
                {
                    "wechatFriendStatus": 1,
                    "customerWechatId": "",
                    "mobile": "13771986452",
                    "rqrAmount": 50,
                    "customerCode": "AAC13070404916",
                    "salary": "",
                    "exeStatus": 1,
                    "hasPolicy": 2,
                    "contactStatus": 2,
                    "hasHouse": 1,
                    "name": "AAC13070404916",
                    "comment": "需要",
                    "hasCars": 1,
                    "job": "企业主",
                    "paymentDate": "2016-08-10 00:00:00",
                    "rqrDuration": 12,
                    "isSecuityOrFund": 0,
                    "workPlace": "苏州市"
                }
            ]
        },
        "msg": "操作成功"
    }


## 5. 编辑客户备注

> POST /api/customer/editComment  

### 参数

入参说明：

|Key|Value|类型|说明|
|---|---|---|---|
|customerCode|客户编号|String|---|
|comment|备注内容|String|不大于500字|

入参示例:

    {
      "customerCode": "AFC14101000001",
      "comment":"你好",
    }
  
### 响应

响应示例:
    
    {
    	msg:"编辑备注成功",
    	code:0,
        data:null
    }


## 6. 获取短信模板

> GET /api/sms/templates  

### 参数

入参说明： 无参数

### 响应

响应说明：

返回短信模板列表    

|Key|Value|类型|说明|
|---|---|---|---|
|id       |模板id|String|---| 
|title    |模板标题|String|---|   
|content  |模板内容|String|---|   

响应示例:

    {
    	msg:"操作成功"
    	code:0
    	data:
    			 [
    				{
	    				" id ": “0”,
	    				" title ": "回访模板",
	    				" content ": "恭喜你成功放款一个亿"
    				},
    				{
	    			    " id ": “1”,
	    				" title ": "回访模板1",
	    				" content ": "恭喜你成功放款三个亿"
    				}
    			]
    
    }


## 7. 同步手机短信

> POST /api/sms/addMessages

### 参数

入参说明： 

|Key|Value|类型|说明|
|---|---|---|---|
|sender       |发送者编号|String|---| 
|receiver     |接收方编号|String|---|
|senderRole   |谁发送|int|1:销售 2:客户|
|occurTime    |发送时间|Date|---|
|content      |发送内容|String|---|
|senderMobile |发送者号码|String|---|
|receiverMobile  |接受者号码|String|---|
|senderName      |发送者名字|String|---|
|receiverName    |接受者名字|String|---|
|signature       |签名|String|默认是【东方融资网】|
|sendStatus   |发送状态|int|1:成功 0:失败|
|isRead   |读取状态|int|默认是1|

入参示例:

      [
	    {
		    "sender": "AFC14101000001",
			"receiver": "AA0396",
			"senderRole": 2,
			"occurTime": "2018-09-07 07:53:41.300",
			"content": "1111客户给销售发短信测试",
			"senderMobile": "13906509892",
			"receiverMobile": "",
			"senderName": "AFC14101000001",
			"receiverName": "赵静[AA0396]",
			"signature": "【东方融资网】",
			"sendStatus": 1,
			"isRead": 1
	    },
	    {
		    "sender": "AA0396",
			"receiver": "AFC14101000001",
			"senderRole": 1,
			"occurTime": "2018-09-07 06:53:41.300",
			"content": "22222销售给客户发短信测试",
			"senderMobile": "",
			"receiverMobile": "13906509892",
			"senderName": "赵静[AA0396]",
			"receiverName": "AFC14101000001",
			"signature": "【东方融资网】",
			"sendStatus": 1,
			"isRead": 1
	    }
      ]
    

### 响应

响应说明：

|Key|Value|类型|说明|
|---|---|---|---|
|msg       |操作信息|String|---| 
|code      |响应编码|int|---|   
|data      |最后一次操作的毫秒数|String|---|  

响应示例:
  
    {
    	msg:"编辑备注成功"
    	code:0
        data:"1537348268039" 
    }



## 8. 获取短信列表

> POST /api/sms/getMessages

### 参数

入参说明：

|Key|Value|类型|说明|
|---|---|---|---|
|empCode|销售工号|String|---|
|customerCode|客户工号|String|---|
|empName  |销售姓名|String|---|
|customerMobile|客户手机号码|String|---|
|pageSize|每页记录行数|int|从1开始|
|pageIndex|初始化加载第几页|int|从1开始|

入参示例:
    
    {
      "empCode": "AA0396",
      "customerCode": "AFC14101000001",
      "customerMobile":"13906509892",
       "empName":"AFC14101000001",
      "pageSize": 10,
      "pageIndex": 1
    }

### 响应

响应说明：

|Key|Value|类型|说明|
|---|---|---|---|
|sender       |发送者编号|String|---| 
|receiver     |接收方编号|String|---|
|senderRole   |谁发送|int|1:销售 2:客户|
|occurTime    |发送时间|Date|---|
|content      |发送内容|String|---|
|senderMobile |发送者号码|String|---|
|receiverMobile  |接受者号码|String|---|
|senderName      |发送者名字|String|---|
|receiverName    |接受者名字|String|---|
|signature       |签名|String|默认是【东方融资网】|
|sendStatus   |发送状态|int|1:成功 0:失败|
|isRead   |读取状态|int|默认是1|
|msg       |操作信息|String|---| 
|code      |响应编码|int|---|   
|data      |响应数据集合|String|---|  
|total     |响应数据总条数|int|---|  
|rows      |响应数据集|List|---|  


响应示例:

    {
	    msg:"操作成功"
	    code:0
	    data:
		    {
	    	  total: 2
	    	  rows:[
						 {
							"sender": "",
							"receiver": "xxxxxxxx",
							"senderRole": 2,
							"occurTime": "2018-08-29 06:53:41.30",
							"content": "xxxxxxxxx",
							"senderMobile": "xxxxxxxxx",
							"receiverMobile": "",
							"senderName": "",
							"receiverName": "xxxxxxx",
							"signature": "【东方融资网】",
							"sendStatus": 1,
							"isRead": 1
						},
						{
							"sender": "xxxxxxxxx",
							"receiver": "",
							"senderRole": 1,
							"occurTime": "2018-08-29 06:53:41.30",
							"content": "xxxxxxxxx",
							"senderMobile": "",
							"receiverMobile": "xxxxxxxxx",
							"senderName": "xxxxxxxxxxxx",
							"receiverName": "",
							"signature": "【东方融资网】",
							"sendStatus": 1,
							"isRead": 1
						}
	    			]
		    	}
    }


## 9. 同步手机通话记录

> POST /api/call/syncRecords

### 参数

入参说明：

入参为通话记录列表，列表按照时间(callDate)倒叙排列的，即第一条是最后的时间。

|Key|Value|类型|说明|
|---|---|---|---|
|mobile|客户手机号码|String|---|
|billSec|通话时长(秒)|int|---|
|callDate|拨打时间|Date|---|
|empWorkMobile|销售手机号码|String|---|
|empCode|销售编号|String|---|
|callStatus|通话类型|int|0：销售未拨打客户<br/>1：销售拨打客户，客户接通 <br/> 2：销售拨打了客户，但是客户未接通<br/> 3：客户拨打销售，销售未接<br/> 4：客户拨打销售，销售接通|

PS: 根据通话类型，可以确认：    

1. 拨打者是什么角色: 销售/客户   
2. 电话拨打状态：接听/呼叫/呼叫未接听

入参示例:
    
    [
        {
            "mobile":"xxxxxxxx",
            "billSec":40,
            "callDate":"2018-08-30 18:30:55",
            "empWorkMobile":"",
            "empCode":"XXXX",
            "callStatus":1
        }
    ]

### 响应

响应说明：  

|Key|Value|类型|说明|
|---|---|---|---|
|data|最后一次通话记录同步时间|timestramp|精确到毫秒|

响应示例:

    {
        msg:"操作成功"
        code:0
        data:1537345115000
    }

### 备注

在涉及到短信和电话的时候，发送/接收都是销售的时候，那么发送编号就是工号，发送号码就是空字符串； 发送/接收都是客户的时候，就一个是客户编号，一个是客户手机号码，后续存在工号和手机号码对应数据后能处理。

## 10. 发送添加微信好友请求（已弃用）

> POST /api/wechat/addFriend

### 参数

入参说明：

|Key|Value|类型|说明|
|---|---|---|---|
|customerMobile|客户手机号码|String|---|
|customerWechatId|客户微信ID|String|---|
|customerName|客户姓名|String|用于微信备注客户|
|empWorkMobile|销售手机号码|String|---|
|empWechatId|销售微信ID|String|---|
|empName|销售姓名|String|用于微信提示客户备注销售|

入参示例:

    {
        "customerMobile": "18522222222",
        "customerWechatId": "",
        "customerName": "普陀",
        "empWorkMobile": "18511111111",
        "empWechatId": "wxid_xbeakwi8vj9q22",
        "empName": "黄埔"
    }

### 响应

响应说明：  

|Key|Value|类型|说明|
|---|---|---|---|
|friendStatus|微信好友关系状态|int|3：微信好友申请中|

响应示例:

    {
        msg:"操作成功",
        code:0,
        data:3
    }

## 11. 更新微信好友状态

> POST /api/wechat/updateFriendStatus

### 参数

入参说明：

|Key|Value|类型|说明|
|---|---|---|---|
|customerMobile|客户手机号码|String|---|
|friendStatus|微信好友关系状态|String|1:非微信好友<br>6:已经是微信好友|

入参示例:

    {
        "customerMobile": "18722222222",
        "friendStatus": 1
    }

### 响应

响应示例:

    {
        msg:"操作成功",
        code:0,
        data:null
    }

