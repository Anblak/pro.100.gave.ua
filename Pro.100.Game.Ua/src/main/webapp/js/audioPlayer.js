function audioPlayer() {
	var currentSong = 0;
	var pauses = document.getElementById('stopMusic');
	$("#audioPlayer")[0].src;
	$("#audioPlayer")[0].pause();
	$("#playlist li a")
			.click(
					function(e) {
						e.preventDefault();
						$("#audioPlayer")[0].src = this;
						$("#audioPlayer")[0].play();
						$("#audioPlayer")[0].controls = true;
						$("#playlist li").removeClass("current-song");

						currentSong = $(this).parent().index();
						$(this).parent().addClass("current-song");
						$("#playerMusic")[0].innerHTML = $("#playlist li a div")[currentSong].innerHTML;
						// $("#playerMusic")[0].innerHTML =
						// $("#divNameMusic")[currentSong].innerHTML;

					});

	$("#audioPlayer")[0]
			.addEventListener(
					"ended",
					function() {
						currentSong++;
						if (currentSong == $("#playlist li a").length)
							currentSong = 0;
						$("#playlist li").removeClass("current-song");
						$("#playlist li:eq(" + currentSong + ")").addClass(
								"current-song");
						$("#audioPlayer")[0].src = $("#playlist li a")[currentSong].href;
						$("#audioPlayer")[0].play();

						$("#playerMusic")[0].innerHTML = $("#playlist li a div")[currentSong].innerHTML;

					});
	// Находим кнопку и прикрепляем метод на событие onclick

	$("#audioPlayer")[0].addEventListener("pause", function() {

		$("#playerMusic")[0].innerHTML = ""
		// $("#divButtonStop")[currentSong].style = "display:none;";
		// $("#divButtonStop")[currentSong].innerHTML = "";
	},false);

}

// HTMLAudioElement.prototype.stop = function() {
// this.pause();
// this.currentTime = 0.0;
// }
