package ua.game.pro.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import resources.creatorHTMLTag.CreatorHTMLTag;
import ua.game.pro.entity.MusicFile;
import ua.game.pro.service.MusicFileService;

@Controller
public class MediaController {

	@Autowired
	private MusicFileService musicFileService;
	private CreatorHTMLTag creator = new CreatorHTMLTag();

	@RequestMapping(value = "/saveMusic", method = RequestMethod.POST)
	public String addMusic(@RequestParam MultipartFile multipartFile) {

		String name = "";
		String fullNameFile = multipartFile.getOriginalFilename();

		int numberPoint = 0;
		int numberTegPoint = 0;

		for (int i = 0; i < fullNameFile.length(); i++) {
			if (fullNameFile.charAt(i) == '.') {
				numberPoint++;
				numberTegPoint = i;
			}
		}

		for (int i = 0; i < numberTegPoint; i++) {

			name += fullNameFile.charAt(i);

		}

		musicFileService.saveMusic(multipartFile);
		MusicFile musicFile = new MusicFile();
		musicFile.setName(name);
		musicFile.setPath("audio/" + multipartFile.getOriginalFilename());
		musicFileService.save(musicFile);

		return "redirect:/";

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String showMusic(Model model) {

		String fileMusic = "";
		ArrayList<MusicFile> list = (ArrayList<MusicFile>) musicFileService.findAll();
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				fileMusic += creator.li(creator.a(list.get(i).getPath(), "", "",
						creator.div(list.get(i).getName(), "", "container musicDiv")), "current-song");
			} else {
				fileMusic += creator.li(creator.a(list.get(i).getPath(), "", "",
						creator.div(list.get(i).getName(), "", "container musicDiv")), "");
			}

		}
		model.addAttribute("music", fileMusic);
		return "redirect:/";

	}

}
