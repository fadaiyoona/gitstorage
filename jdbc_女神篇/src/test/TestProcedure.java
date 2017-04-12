package test;

import java.sql.SQLException;
import java.util.List;

import model.Goddess;
import dao.ProcedureDao;

public class TestProcedure {

	public static void main(String[] args) throws SQLException {
		ProcedureDao.select_nofilter();

		List<Goddess> gs = ProcedureDao.select_filter("Wife");
		for (Goddess g : gs) {
			System.out.println(g);
		}
	}

}
