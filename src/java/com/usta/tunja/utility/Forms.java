/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usta.tunja.utility;

import java.util.List;
import javax.faces.model.SelectItem;

public class Forms {

    public static SelectItem[] addObject(List<?> objectsList, String textFirstChoice) {
        int index, size;
        SelectItem[] itemsList;

        index = 0;
        size = objectsList.size();
        if (textFirstChoice != null && !textFirstChoice.isEmpty()) {
            size = size + 1;
            index = index + 1;
            itemsList = new SelectItem[size];
            itemsList[0] = new SelectItem("", textFirstChoice);
        } else {
            itemsList = new SelectItem[size];
        }

        for (Object obj : objectsList) {
            itemsList[index] = new SelectItem(obj, obj.toString());
            index++;
        }
        return itemsList;

    }

}
