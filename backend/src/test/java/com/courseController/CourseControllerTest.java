package com.courseController;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.OsuAppApplication;
import com.osuapp.constants.ApplicationConstants;
import com.osuapp.model.Course;
import com.osuapp.service.CourseService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = OsuAppApplication.class)
@WebMvcTest(CourseController.class)
public class CourseControllerTest {
	
	//auto wiring the service
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	CourseService courseService;
	
	private static Course testCourse = new Course();
	private static List<String> testCourseList = new ArrayList<>();
	
	@BeforeClass
	public static void initTestClass() {
		testCourse.setDepartmentName(ApplicationConstants.GENERIC_DEPARTMENT_NAME);
		testCourseList.add(ApplicationConstants.GENERIC_COURSE_OFFERING);
		testCourse.setCourseList(testCourseList);
	}

	@Test
	public void getAllCourses() throws  Exception {
		Mockito.when(courseService.getAllCourses(Mockito.anyString())).thenReturn(testCourse);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(ApplicationConstants.GENERIC_GET_ALL_COURSES_URL).accept(MediaType.APPLICATION_JSON);
		MvcResult testResult = this.mockMvc.perform(requestBuilder).andReturn();
		JSONAssert.assertEquals(ApplicationConstants.EXPECTED_TEST_COURSE_RESULT, testResult.getResponse().getContentAsString(), false);
	}
}
