package com.redlxians.quiz.model;
/**
*@author AJAY E.S
**/
public class Quiz
{
	private String question;
	private String answer;
	private String [] option=new String[4];
	public void setQuestion(question)
	{
		this.question=question;
	}
	public String getQuestion()
	{
        return question;
	}
	public void setAnswer(answer)
	{
		this.answer=answer;
	}
	public String getAnswer()
	{
        return answer;
	}
	public void setOption(String [] option)
	{
		this.option=option;
	}
	public String [] getOption()
	{
        return option;
	}
}