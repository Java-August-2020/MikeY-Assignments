package com.mike.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mike.dojooverflow.models.Answer;
import com.mike.dojooverflow.models.NewQuestion;
import com.mike.dojooverflow.models.Question;
import com.mike.dojooverflow.models.Tag;
import com.mike.dojooverflow.repositories.AnswerRepository;
import com.mike.dojooverflow.repositories.QuestionRepository;
import com.mike.dojooverflow.repositories.TagRepository;



@Service
public class AppService {
	@Autowired
	AnswerRepository aRepo;
	@Autowired
	TagRepository tRepo;
	@Autowired
	QuestionRepository qRepo;
	
	public List<Question> getQuestions() {
		return this.qRepo.findAll();
	}
	
	public Question getQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
		
	}
	
	public void createQuestion(NewQuestion question) {
		List<Tag> questionsTags = new ArrayList<Tag>();
		for(String subject: question.splitTags()) {
			Tag tag = this.tRepo.findBySubject(subject).orElse(null);
			
			if(tag == null) {
				tag = new Tag(subject);
				this.tRepo.save(tag);
			}
			// prevent dupe tags
			if(!questionsTags.contains(tag))
				questionsTags.add(tag);
		}
		Question newQuestion = new Question(question.getQuestion(), questionsTags);
		this.qRepo.save(newQuestion);
	}
	public Answer createAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
}
