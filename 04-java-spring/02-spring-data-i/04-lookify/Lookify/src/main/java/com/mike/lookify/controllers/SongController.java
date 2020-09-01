package com.mike.lookify.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mike.lookify.models.Song;
import com.mike.lookify.services.SongService;

@Controller
public class SongController {
	
	@Autowired
	private SongService sService;

	@RequestMapping("/")
	public String index (Model viewModel) {
		return "index.jsp";
	}
	
	//the dashboard
	@RequestMapping("/dashboard")
	public String dashboard(Model viewModel) {
		viewModel.addAttribute("songs", sService.getAllSongs());
		return "/dashboard.jsp";
	}
	
	//show song by id
	@RequestMapping("/dashboard/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("song", sService.findSong(id));
		return "show.jsp";
	}
	
	//new song page
	@RequestMapping("/new")
	public String newDisplay(@ModelAttribute("song") Song song) {
		return "new.jsp";
	}
	
	//actually create new song
	@PostMapping("/dashboard")
	public String createNew(@Valid @ModelAttribute("song") Song newSong, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		} else { 
			this.sService.createSong(newSong);
			return "redirect:/dashboard";
		}
	}
	
	// search for artist
	@RequestMapping("/dashboard/search")
	public String search(@RequestParam("artist") String artist, Model viewModel) {
		viewModel.addAttribute("songs",	sService.songsContainingArtist(artist));
		viewModel.addAttribute("artist", artist);
		return "searched.jsp";
	}
	
	//search top ten
	@RequestMapping("/dashboard/topTen")
	public String topTen(Model viewModel) {
		viewModel.addAttribute("songs", sService.topTenByRating());
		return "topTen.jsp";
	}
	
	//delete song
	@RequestMapping(value="/dashboard/{id}", method=RequestMethod.DELETE)
	 public String delete(@PathVariable("id") Long id) {
		sService.deleteSong(id);
		return "redirect:/dashboard";
	}
}