//calling Java-servlet

function XHRrequest(){
	var url = "/TextSummarization/input";//http://localhost:8085/....
	var var_str = "fullText=" + document.getElementById("element_1").value;
    var ret = postAsync(url, var_str);
    if (ret.match(/^XHR error/)) {console.log(ret);return;}
    document.getElementById("summarized_text").innerHTML=ret;
}

function postAsync(url2get, sendstr)    {
    var req;
    if (window.XMLHttpRequest) {
        req = new XMLHttpRequest();
        } else if (window.ActiveXObject) {
        req = new ActiveXObject("Microsoft.XMLHTTP");
        }
    if (req != undefined) {
        req.overrideMimeType("application/json;charset=UTF-8"); // if request result is JSON
        try {
            req.open("POST", url2get, false); // 3rd param is whether "async"
            }
        catch(err) {
            alert("couldnt complete request. Is JS enabled for that domain?\\n\\n" + err.message);
            return false;
            }
        req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");//"application/json;charset=UTF-8");
        req.send(sendstr); // param string only used for POST

        if (req.readyState == 4) { // only if req is "loaded"
            if (req.status == 200)  // only if "OK"
                { return req.responseText ; }
            else    { return "XHR error: " + req.status +" "+req.statusText; }
            }
        }
    alert("req for getAsync is undefined");
}
