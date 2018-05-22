function menuLeftOpen() {
	document.getElementById('mainMenu').style.left = "0px";
	document.getElementById('leftIndecatorMenu').style.left = "300px";
	document.getElementById('leftIndecatorMenu').style.width = "100%";
	document.getElementById('leftIndecatorMenu').style.opacity = "0.5";
	document.getElementById('audiom').style.display = 'none';
	document.getElementById('userSettingsm').style.display = 'none';
	document.getElementById('savephotom').style.display = 'none';
	document.getElementById('savemusicm').style.display = 'none';
}
function menuLeftClose() {
	document.getElementById('mainMenu').style.left = "-300px";
	document.getElementById('leftIndecatorMenu').style.left = "0px";
	document.getElementById('leftIndecatorMenu').style.width = "15px";
	document.getElementById('leftIndecatorMenu').style.opacity = "0";

}
function menuController() {
	if (document.getElementById('leftIndecatorMenu').style.left == "300px") {
		menuLeftClose();
	} else {

		menuLeftOpen();
	}
}
