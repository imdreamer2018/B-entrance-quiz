package com.thoughtworks.capability.gtb.entrancequiz;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GtbEntranceQuizApplication implements ApplicationRunner {

	final StudentService studentService;

	public GtbEntranceQuizApplication(StudentService studentService) {
		this.studentService = studentService;
	}

	public static void main(String[] args) {
		SpringApplication.run(GtbEntranceQuizApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		String[] students = {
				"成吉思汗", "鲁班七号", "太乙真人",
				"钟无艳", "花木兰", "雅典娜",
				"芈月", "白起", "刘禅",
				"庄周", "马超", "刘备",
				"哪吒", "大乔", "蔡文姬"
		};
		for (int i = 0; i < students.length; i++) {
			studentService.createStudent(new Student(i + 1, students[i]));
		}

	}
}
