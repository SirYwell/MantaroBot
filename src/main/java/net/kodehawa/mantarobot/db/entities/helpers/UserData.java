/*
 * Copyright (C) 2016-2018 David Alejandro Rubio Escares / Kodehawa
 *
 * Mantaro is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Mantaro is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Mantaro.  If not, see http://www.gnu.org/licenses/
 */

package net.kodehawa.mantarobot.db.entities.helpers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import net.kodehawa.mantarobot.data.MantaroData;
import net.kodehawa.mantarobot.db.entities.Marriage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class UserData {
    private String birthday;
    private boolean hasReceivedFirstKey; //Placeholder here for rethonk plz
    private String premiumKey;
    private int reminderN;
    private String timezone;
    private String lang;
    private int dustLevel; //percentage

    private boolean receivedExpirationWarning; //premium key about to expire!

    //NEW MARRIAGE SYSTEM
    private String marriageId;
    //user id, value bought for.
    private Map<String, Long> waifus = new HashMap<>();
    private int waifuSlots = 3;
    private int timesClaimed;

    //Persistent reminders. UUID is saved here.
    private List<String> reminders = new ArrayList<>();

    @JsonIgnore
    public Marriage getMarriage() {
        //we're going full round trip here
        return MantaroData.db().getMarriage(marriageId);
    }

}
