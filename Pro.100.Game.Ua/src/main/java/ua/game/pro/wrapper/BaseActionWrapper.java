package ua.game.pro.wrapper;

import java.util.HashSet;

import org.springframework.stereotype.Service;

import BaseActions.BaseActions;
import DiscreteMath.Exceptions.DiscreteMathException;

@Service
public class BaseActionWrapper {
	
	private String formul;
	private String space;
	
	public HashSet<Integer> getBaseActions(){
		try {
			return new BaseActions().baseOperationOnSpace(formul, space);
		} catch (DiscreteMathException e) {}
		return null;
		
	}
	
	public BaseActionWrapper() {
		// TODO Auto-generated constructor stub
	}

	public BaseActionWrapper(String formul, String space) {
		super();
		this.formul = formul;
		this.space = space;
	}

	public String getFormul() {
		return formul;
	}

	public void setFormul(String formul) {
		this.formul = formul;
	}

	public String getSpace() {
		return space;
	}

	public void setSpace(String space) {
		this.space = space;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formul == null) ? 0 : formul.hashCode());
		result = prime * result + ((space == null) ? 0 : space.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseActionWrapper other = (BaseActionWrapper) obj;
		if (formul == null) {
			if (other.formul != null)
				return false;
		} else if (!formul.equals(other.formul))
			return false;
		if (space == null) {
			if (other.space != null)
				return false;
		} else if (!space.equals(other.space))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseActionWrapper [formul=" + formul + ", space=" + space + "]";
	}
	
	
	
	
}