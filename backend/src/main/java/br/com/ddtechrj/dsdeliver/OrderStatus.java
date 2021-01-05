package br.com.ddtechrj.dsdeliver;

public enum OrderStatus {
	
	PANDING(0, "PENDING"), 
	DELIVERED(1, "DELIVERED");
	
	private int cod; 
	private String description;
	
	
	private OrderStatus(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}


	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	} 
	
	public OrderStatus toEnum(Integer cod) { 
		if(cod == null) { 
			return null; 
		}
		
		for(OrderStatus x : OrderStatus.values()) { 
			if(x.getCod() == cod) { 
				return x;
			}
		}
		
		throw new IllegalArgumentException("invalid id: "+ cod);
	}

}
