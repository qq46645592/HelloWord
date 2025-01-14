/*
 * Copyright (C) 2007-2012 Geometer Plus <contact@geometerplus.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package com.mobile.meishang.core.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 
 * @Title:
 * @Description:������
 * @Author:11120500
 * @Since:2013-4-24
 * @Version:
 */
public abstract class ZLMiscUtil
{
    /**
     * 
     * @Description:
     * @Author Administrator
     * @Date 2013-5-2
     */
    public static <T> boolean equals(T o0, T o1)
    {
        return o0 == null ? o1 == null : o0.equals(o1);
    }

    /**
     * 
     * @Description:
     * @Author Administrator
     * @Date 2013-5-2
     */
    public static boolean isEmptyString(String s)
    {
        return s == null || "".equals(s);
    }

    /**
     * 
     * @Description:
     * @Author Administrator
     * @Date 2013-5-2
     */
    public static int hashCode(Object o)
    {
        return o != null ? o.hashCode() : 0;
    }

    /**
     * 
     * @Description:
     * @Author Administrator
     * @Date 2013-5-2
     */
    public static <T> boolean listsEquals(List<T> list1, List<T> list2)
    {
        if (list1 == null)
        {
            return list2 == null || list2.isEmpty();
        }
        if (list1.size() != list2.size())
        {
            return false;
        }
        return list1.containsAll(list2);
    }

    /**
     * 
     * @Description:
     * @Author Administrator
     * @Date 2013-5-2
     */
    public static <KeyT, ValueT> boolean mapsEquals(Map<KeyT, ValueT> map1,
            Map<KeyT, ValueT> map2)
    {
        if (map1 == null)
        {
            return map2 == null || map2.isEmpty();
        }
        if (map1.size() != map2.size()
                || !map1.keySet().containsAll(map2.keySet()))
        {
            return false;
        }
        for (KeyT key : map1.keySet())
        {
            final ValueT value1 = map1.get(key);
            final ValueT value2 = map2.get(key);
            if (!equals(value1, value2))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * 
     * @Description:
     * @Author Administrator
     * @Date 2013-5-2
     */
    public static boolean matchesIgnoreCase(String text, String lowerCasePattern)
    {
        return (text.length() >= lowerCasePattern.length())
                && (text.toLowerCase().indexOf(lowerCasePattern) >= 0);
    }

    /**
     * 
     * @Description:
     * @Author Administrator
     * @Date 2013-5-2
     */
    public static String listToString(List<String> list, String delimiter)
    {
        if (list == null || list.isEmpty())
        {
            return "";
        }
        final StringBuilder builder = new StringBuilder();
        boolean first = true;
        for (String s : list)
        {
            if (first)
            {
                first = false;
            }
            else
            {
                builder.append(delimiter);
            }
            builder.append(s);
        }
        return builder.toString();
    }

    /**
     * 
     * @Description:
     * @Author Administrator
     * @Date 2013-5-2
     */
    public static List<String> stringToList(String str, String delimiter)
    {
        if (str == null || "".equals(str))
        {
            return Collections.emptyList();
        }
        return Arrays.asList(str.split(delimiter));
    }
}
