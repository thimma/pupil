/**
 * Send email confirmation
 */

function show_alert() {
  if(confirm("Click ok to save job and send email.Else,click cancel to Save job without sending email")){
	document.getElementsByName("send_email").innerHTML="Y";  
    document.forms[0].submit();
    return true;
    }
  else{
	document.getElementsByName("send_email").innerHTML="N";  
  	document.forms[0].submit();  	
    return true;
    }
}