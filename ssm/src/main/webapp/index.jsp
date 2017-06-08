<%@ page contentType="text/html;charset=utf-8"%>
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>JS判断密码强度</title>  
<script language=javascript>    

    //返回强度级别    
    function checkStrong(sPW){    
    	 var strongRegex = new RegExp("^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
    	 var mediumRegex = new RegExp("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g");
    	 var enoughRegex = new RegExp("(?=.{6,}).*", "g");
    	 if (false == enoughRegex.test(sPW)) {
    		return 0;
    	 } else if (strongRegex.test(sPW)) {
			return 3;
    	 } else if (mediumRegex.test(sPW)) {
			return 2;
    	 } else {
			return 1;
    	 }  
    }  
    
    //显示颜色    
    function pwStrength(pwd){    
        Dfault_color="#eeeeee";     //默认颜色  
        L_color="#FF0000";      //低强度的颜色，且只显示在最左边的单元格中  
        M_color="#FF9900";      //中等强度的颜色，且只显示在左边两个单元格中  
        H_color="#33CC00";      //高强度的颜色，三个单元格都显示  
        if (pwd==null||pwd==''){    
            Lcolor=Mcolor=Hcolor=Dfault_color;  
        }    
        else{    
            S_level=checkStrong(pwd);    
            switch(S_level) {    
            case 0:    
                Lcolor=Mcolor=Hcolor=Dfault_color;  
                break;  
            case 1:    
                Lcolor=L_color;  
                Mcolor=Hcolor=Dfault_color;  
                break;    
            case 2:    
                Lcolor=Mcolor=M_color;    
                Hcolor=Dfault_color;    
                break;    
            default:    
                Lcolor=Mcolor=Hcolor=H_color;    
        }    
    }    
    document.getElementById("strength_L").style.background=Lcolor;    
    document.getElementById("strength_M").style.background=Mcolor;    
    document.getElementById("strength_H").style.background=Hcolor;    
    return;  
}  
</script>  
</head>  
<body>  
<form name=form1 action="" >  
    <table width="250" border="0" cellpadding=2" bordercolor="#eeeeee" style='display:inline'>  
        <tr>  
            <td width="40%" align="right">密码:</td>  
            <td colspan="3" align="left">  
                <input type=password size=20 onKeyUp=pwStrength(this.value) />  
            </td>  
        </tr>   
        <tr align="center">  
            <td width="40%" align="right">密码强度:</td>  
            <td width="20%" id="strength_L" bgcolor="#eeeeee">弱</td>    
            <td width="20%" id="strength_M" bgcolor="#eeeeee">中</td>    
            <td width="20%" id="strength_H" bgcolor="#eeeeee">强</td>    
        </tr>  
    </table>  
</form>  
</body>  
</html>  