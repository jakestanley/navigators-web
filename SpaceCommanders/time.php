<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>elapsed time demo</title>
    <script type="text/javascript">
        var time0;
        function initTime() {
            time0 = new Date();
            window.setInterval("updateTime()", 1000);
        }
        function updateTime() {
            var timeNow = new Date();
            var deltas = (Number(timeNow) - Number(time0))/1000;
            var deltah = ("0"+String(Math.round(deltas / 3600))).substr(-2);
            deltah = deltah.substr(-2);
            deltas %= 3600;
            var deltam = ("0"+String(Math.round(deltas / 60))).substr(-2);
            deltas = ("0"+String(Math.round(deltas % 60))).substr(-2);
            document.getElementById("timedisplay").firstChild.data=deltah+":"+deltam+":"+deltas;
        }
    </script>
</head>
<body onload="initTime();">
    <div> elapsed time <span id="timedisplay">00:00:00</span></div>
</body>
</html>​