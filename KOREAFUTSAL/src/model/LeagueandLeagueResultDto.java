package model;

import java.sql.Date;

public class LeagueandLeagueResultDto {
	String league_name;
	Date league_date;
	int league_code;
	int branch_no;
	int league_point;
	int league_result_code;
	int league_win;
	int league_lose;
	int league_draw;
	int league_gf;
	int league_ga;
	int t_code;
	String t_name;
	String branch_name;
	
	
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getLeague_name() {
		return league_name;
	}
	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}
	public Date getLeague_date() {
		return league_date;
	}
	public void setLeague_date(Date league_date) {
		this.league_date = league_date;
	}
	public int getLeague_code() {
		return league_code;
	}
	public void setLeague_code(int league_code) {
		this.league_code = league_code;
	}
	public int getBranch_no() {
		return branch_no;
	}
	public void setBranch_no(int branch_no) {
		this.branch_no = branch_no;
	}
	public int getLeague_point() {
		return league_point;
	}
	public void setLeague_point(int league_point) {
		this.league_point = league_point;
	}
	public int getLeague_result_code() {
		return league_result_code;
	}
	public void setLeague_result_code(int league_result_code) {
		this.league_result_code = league_result_code;
	}
	public int getLeague_win() {
		return league_win;
	}
	public void setLeague_win(int league_win) {
		this.league_win = league_win;
	}
	public int getLeague_lose() {
		return league_lose;
	}
	public void setLeague_lose(int league_lose) {
		this.league_lose = league_lose;
	}
	public int getLeague_draw() {
		return league_draw;
	}
	public void setLeague_draw(int league_draw) {
		this.league_draw = league_draw;
	}
	public int getLeague_gf() {
		return league_gf;
	}
	public void setLeague_gf(int league_gf) {
		this.league_gf = league_gf;
	}
	public int getLeague_ga() {
		return league_ga;
	}
	public void setLeague_ga(int league_ga) {
		this.league_ga = league_ga;
	}
	public int getT_code() {
		return t_code;
	}
	public void setT_code(int t_code) {
		this.t_code = t_code;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	
	
}
