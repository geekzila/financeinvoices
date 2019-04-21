package com.hilti.financeinvoices.levels;
public class Invoice {

	private Integer id;

	private String name;

	private String branch;

	private Boolean status;

	/**
	 * @param id
	 * @param name
	 * @param branch
	 * @param status
	 */
	public Invoice(Integer id, String name, String branch, Boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.status = status;
	}

	/**
	 * @param name
	 * @param branch
	 * @param status
	 */
	public Invoice(String name, String branch, Boolean status) {
		super();
		this.name = name;
		this.branch = branch;
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Object getSno() {
		// TODO Auto-generated method stub
		return null;
	}

}
