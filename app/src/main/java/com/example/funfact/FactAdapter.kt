package com.example.funfact

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FactAdapter(context: Context, facts: List<FactModel>) :
    ArrayAdapter<FactModel>(context, 0, facts) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val fact = getItem(position)
        if (view == null) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.fact_item, parent, false)
        }
        val logo = view?.findViewById<ImageView>(R.id.imageLogo)
        val name = view?.findViewById<TextView>(R.id.name)
        val secondaryText = view?.findViewById<TextView>(R.id.secondary_text)
        val supportingText = view?.findViewById<TextView>(R.id.supporting_text)
        fact?.logo?.let {
            logo?.setImageResource(fact.logo)
        }
        name?.text = fact?.name
        secondaryText?.text = fact?.about
        supportingText?.text = fact?.fact
        view?.setOnClickListener {
            val intent = Intent(parent.context, DetailActivity::class.java)
            intent.putExtra(LOGO_EXTRAS, fact?.logo)
            intent.putExtra(NAME_EXTRAS, fact?.name)
            intent.putExtra(FACT_EXTRAS, fact?.fact)
            intent.putExtra(ABOUT_EXTRAS, fact?.about)
            parent.context.startActivity(intent)

        }
        return view!!
    }

    companion object {
        val LOGO_EXTRAS = "logo_extras"
        val NAME_EXTRAS = "name_extras"
        val FACT_EXTRAS = "fact_extras"
        val ABOUT_EXTRAS = "about_extras"
    }
}