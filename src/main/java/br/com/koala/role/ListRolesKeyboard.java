package br.com.koala.role;

import static br.com.koala.configuration.Command.NEW_ROLE;

import java.util.List;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;

public class ListRolesKeyboard {
	
	public  static final String LIST_ROLE_PREFIX = "/list-role_";
	public static final String REMOVE_ROLE_PREFIX = "/remove-role_";
	
	private final static int PAGE_SIZE = 4;
	
	private final List<Role> roles;
	private final int page;

	public ListRolesKeyboard(List<Role> roles, int page) {
		this.roles = roles;
		this.page = page;
	}
	
	public ListRolesKeyboard(List<Role> roles) {
		this.roles = roles;
		this.page = 0;
	}

	public InlineKeyboardMarkup buildKeyboard() {
		int factor = page * PAGE_SIZE;
		
		return new InlineKeyboardMarkup(header(), getRole(1 + factor), getRole(2 + factor), getRole(3 + factor), getRole(4 + factor), pagination());
	}
	
	private InlineKeyboardButton[] header() {
		InlineKeyboardButton name = new InlineKeyboardButton("Data - Nome").callbackData(" ");
		InlineKeyboardButton remove = new InlineKeyboardButton("Excluir").callbackData(" ");
		
		return new InlineKeyboardButton[] { name, remove};
	}

	private InlineKeyboardButton[] pagination() {
		String backPageText = " ";
		String nextPageText = " ";
		String backPageCallback = " ";
		String nextPageCallback = " ";
		
		if (roles.size() > PAGE_SIZE && page == 0) {
			nextPageText = "Próxima pagina ⇢";
			nextPageCallback = LIST_ROLE_PREFIX + (page + 1);
		} else if (page != 0) {
			boolean isLastPage = roles.size() / PAGE_SIZE <= PAGE_SIZE;
			
			if (isLastPage){
				backPageText = "⇠ Voltar pagina";
				backPageCallback = LIST_ROLE_PREFIX + (page - 1);
			} else {
				backPageText = "⇠ Voltar pagina";
				backPageCallback = LIST_ROLE_PREFIX + (page - 1);
				nextPageText = "Próxima pagina ⇢";
				nextPageCallback = LIST_ROLE_PREFIX + (page + 1);
			}
		}
		InlineKeyboardButton backPage = new InlineKeyboardButton(backPageText).callbackData(backPageCallback);
		InlineKeyboardButton newRole = new InlineKeyboardButton("Marcar novo role").callbackData("/" + NEW_ROLE.getName());
		InlineKeyboardButton nextPage = new InlineKeyboardButton(nextPageText).callbackData(nextPageCallback);
		
		return new InlineKeyboardButton[] { backPage, newRole, nextPage};
	}

	private InlineKeyboardButton[] getRole(int position) {
		if (position <= roles.size()) {
			Role role = roles.get(position - 1);
			
			InlineKeyboardButton roleDetails = new InlineKeyboardButton(role.getFormattedDate() + " - " + role.getTitle()).callbackData(" ");
			InlineKeyboardButton removeRole = new InlineKeyboardButton("\u274C").callbackData(REMOVE_ROLE_PREFIX + role.getId());
			
			return new InlineKeyboardButton[] { roleDetails, removeRole };
		}
		return new InlineKeyboardButton[] { };
	}

}
