function menuLeftOpen() {
	document.getElementById('mainMenu').style.left = "0px";
	document.getElementById('leftIndecatorMenu').style.left = "300px";
	document.getElementById('leftIndecatorMenu').style.width = "100%";
	document.getElementById('leftIndecatorMenu').style.opacity = "0.5";
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
