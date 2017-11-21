package mum.edu.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import mum.edu.domain.EmailHistory;

public class EmailFormatter implements  Formatter<EmailHistory> {

	@Override
	public String print(EmailHistory emailHistory, Locale arg1) {
		// TODO Auto-generated method stub
		return String.valueOf(emailHistory.getEmail());
	}

	@Override
	public EmailHistory parse(String id, Locale arg1) throws ParseException {
		// TODO Auto-generated method stub
		EmailHistory temp = new EmailHistory();
		temp.setEmail(id);
		return temp ;
	}

}
