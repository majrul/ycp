package com.cdac.onlineexam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CalculateScoreServlet
 */
@WebServlet("/CalculateScoreServlet")
public class CalculateScoreServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//QuestionBankLoader questionBankLoader = new QuestionBankLoader();
		//List<Question> questions = questionBankLoader.loadSampleQuestions("Java");

		HttpSession session = request.getSession();
		List<Question> questions = (List<Question>) session.getAttribute("questions");
		
		int optionGroup = 0;
		int score = 0;
		
		for(Question question : questions) {
			int ans = Integer.parseInt(request.getParameter("radio" + ++optionGroup));
			question.setSelectedOption(ans);
			
			Option option = question.getOptions().get(ans);
			if(option.isRightAnswer())
				score ++;
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("You have scored " + score + "/" + questions.size());
		out.println("<h2>You can review the answers below</h2>");
		
		out.println("<ol>");
		for(Question question : questions) {
			out.println("<br><br>  <li>" + question.getQuestion()+" </li>");
			List<Option> options = question.getOptions();
			for(Option option : options) {
				String color="black";
				if(option.isRightAnswer())
					color = "green";
				out.println("<br> <font color="+color+">" + option.getOption()+"</font>");
			}
		}
		out.println("</ol>");
	}

}
