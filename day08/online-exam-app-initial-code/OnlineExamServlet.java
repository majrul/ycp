package com.cdac.onlineexam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OnlineExamServlet
 */
@WebServlet("/OnlineExamServlet")
public class OnlineExamServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int optionGroup = 0;

		out.println("<html><body>");
		out.println("<form action='CalculateScoreServlet'>");
		QuestionBankLoader questionBankLoader = new QuestionBankLoader();
		List<Question> questions = questionBankLoader.loadSampleQuestions("Java");
		out.println("<ol>");
		for(Question question : questions) {
			out.println("<br><br>  <li>" + question.getQuestion()+" </li>");
			optionGroup ++;
			int optionNo=0;
			List<Option> options = question.getOptions();
			for(Option option : options) {
				
				out.println("<br> <input type='radio' name='radio"+optionGroup+"' value='"+optionNo++ +"' />" + option.getOption());
			}
		}
		out.println("</ol>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("</body></html>");
	}

}
