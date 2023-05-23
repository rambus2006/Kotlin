package com.example.todayquote

import android.content.SharedPreferences

data class Quote(var idx:Int,
                 var text:String,
                 var from:String = ""){

    companion object{
        fun saveToPreferences(
            pref:SharedPreferences,
            idx: Int,
            text: String,
            from: String=""){
            //Q) idx,text,from 정보를 이용해서 pref에 Quote의 모든 값을 저장
            // 키를 idx가 1이라면 "1.text","1.from"에 저장
            val editor=pref.edit() //객체 호출
            editor.putString("${idx}.text",text)
            editor.putString("${idx}.from",from)
            editor.apply() //저장하기
        }
        fun removeQuoteFromPreference(
            pref: SharedPreferences,
            idx: Int){
            //editor.remove메서드 사용(키를 전달하면 해당 키, 값 쌍을 지울 수 있음)
            val editor = pref.edit()
            editor.remove("${idx}.text")
            editor.remove("${idx}.from")
            editor.apply()
        }

        fun getQuotesFromPreference(pref: SharedPreferences):MutableList<Quote>{
            val quotes = mutableListOf<Quote>()
            //Q) 01-10까지 반복돌면서 "0.text","0.from"이런식으로 모두 Quote만들어서 quotes에 추가
            for (idx in 0.. 19){
                val text = pref.getString("${idx}.text",null)
                val from = pref.getString("${idx}.from",null)
                if (!(text == null || from == null)) {
                    quotes.add(Quote(idx,text,from))
                }

            }
            return quotes
        }
        fun getQuoteFromPreference(
            pref: SharedPreferences,
            idx:Int):Quote?{
            val text = pref.getString("${idx}.text",null)
            val from = pref.getString("${idx}.from",null)
            return if (text == null || from == null) null
            else {
                return Quote(idx, text, from)
            }
        }

    }
}

    //데이터 클래스 =>주로 메서드의 비중보다는 정보를 hold하는 역할을 하는 객체를 생성하는 용도

    //Quote이름의 클래스 작성

    //idx: Int,text:String,from:String

    //그런데 출처(from)는 제공을 하지 않으면 빈 문자열("")을 디퐅크(기본)값으로 사용

