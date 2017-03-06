function audioPlayer() {
	var currentSong = 0;
	$("#audioPlayer")[0].controls = true;
	$("#audioPlayer")[0].src = $("#playlist li")[currentSong].src = $("#playlist li a")[currentSong].href;
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

	
		$("#playlist li").removeClass("current-song");
		$("#playerMusic")[0].innerHTML = ""
		// $("#divButtonStop")[currentSong].style = "display:none;";
		// $("#divButtonStop")[currentSong].innerHTML = "";
	}, false);

	$("#audioPlayer")[0]
			.addEventListener(
					"play",
					function() {
						$("#playlist li:eq(" + currentSong + ")").addClass(
								"current-song");
						$("#audioPlayerm")[0].pause();
						$("#playerMusic")[0].innerHTML = $("#playlist li a div")[currentSong].innerHTML;
						// $("#divButtonStop")[currentSong].style =
						// "display:none;";
						// $("#divButtonStop")[currentSong].innerHTML = "";
					}, false);
}
function audioPlayerm() {
	var currentSong = 0;
	$("#audioPlayerm")[0].controls = true;
	$("#audioPlayerm")[0].src = $("#playlistm li")[currentSong].src = $("#playlistm li a")[currentSong].href;
	$("#audioPlayerm")[0].pause();
	$("#playlistm li a")
			.click(
					function(e) {
						e.preventDefault();
						$("#audioPlayerm")[0].src = this;
						$("#audioPlayerm")[0].play();
						$("#audioPlayerm")[0].controls = true;
						$("#playlistm li").removeClass("current-songm");

						currentSong = $(this).parent().index();
						$(this).parent().addClass("current-songm");
						$("#playerMusicm")[0].innerHTML = $("#playlistm li a div")[currentSong].innerHTML;
						// $("#playerMusic")[0].innerHTML =
						// $("#divNameMusic")[currentSong].innerHTML;

					});

	$("#audioPlayerm")[0]
			.addEventListener(
					"ended",
					function() {
						currentSong++;
						if (currentSong == $("#playlist li a").length)
							currentSong = 0;
						$("#playlistm li").removeClass("current-songm");
						$("#playlistm li:eq(" + currentSong + ")").addClass(
								"current-songm");
						$("#audioPlayerm")[0].src = $("#playlistm li a")[currentSong].href;
						$("#audioPlayerm")[0].play();

						$("#playerMusicm")[0].innerHTML = $("#playlistm li a div")[currentSong].innerHTML;

					});
	// Находим кнопку и прикрепляем метод на событие onclick

	$("#audioPlayerm")[0].addEventListener("pause", function() {
		$("#playlistm li").removeClass("current-songm");
		$("#playerMusicm")[0].innerHTML = ""
		// $("#divButtonStop")[currentSong].style = "display:none;";
		// $("#divButtonStop")[currentSong].innerHTML = "";
	}, false);

	$("#audioPlayerm")[0]
			.addEventListener(
					"play",
					function() {
						$("#playlistm li:eq(" + currentSong + ")").addClass(
								"current-songm");
						$("#audioPlayer")[0].pause();
						$("#playerMusicm")[0].innerHTML = $("#playlistm li a div")[currentSong].innerHTML;
						// $("#divButtonStop")[currentSong].style =
						// "display:none;";
						// $("#divButtonStop")[currentSong].innerHTML = "";
					}, false);
}

// HTMLAudioElement.prototype.stop = function() {
// this.pause();
// this.currentTime = 0.0;
// }
