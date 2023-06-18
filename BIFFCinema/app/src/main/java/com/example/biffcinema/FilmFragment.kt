package com.example.biffcinema

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.biffcinema.films.*


class FilmFragment : Fragment(), FilmAdapter.MyClickListener {

    private lateinit var adapter: FilmAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var filmArrayList: ArrayList<Film>

    private lateinit var picture: Array<Int>
    private lateinit var title: Array<String>
    private lateinit var director: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_film, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = FilmAdapter(filmArrayList, this@FilmFragment)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize() {
        filmArrayList = arrayListOf<Film>()

        picture = arrayOf(
            R.drawable.century_girl,
            R.drawable.a_cambodian_nigths_dream,
            R.drawable.aftersun,
            R.drawable.autobiography,
            R.drawable.before_now_then,
            R.drawable.broker,
            R.drawable.decision_to_leave,
            R.drawable.eeaao,
            R.drawable.holy_spider,
            R.drawable.next_sohee,
            R.drawable.return_to_seoul,
            R.drawable.the_banshees_of_inisherin
        )

        title = arrayOf(
            getString(R.string.title1),
            getString(R.string.title2),
            getString(R.string.title3),
            getString(R.string.title4),
            getString(R.string.title5),
            getString(R.string.title6),
            getString(R.string.title7),
            getString(R.string.title8),
            getString(R.string.title9),
            getString(R.string.title10),
            getString(R.string.title11),
            getString(R.string.title12)
        )

        director = arrayOf(
            getString(R.string.director1),
            getString(R.string.director2),
            getString(R.string.director3),
            getString(R.string.director4),
            getString(R.string.director5),
            getString(R.string.director6),
            getString(R.string.director7),
            getString(R.string.director8),
            getString(R.string.director9),
            getString(R.string.director10),
            getString(R.string.director11),
            getString(R.string.director12)
        )

        for (i in picture.indices) {
            val film = Film(picture[i], title[i], director[i])
            filmArrayList.add(film)
        }
    }

    override fun onClick(position: Int) {
        when(position) {
            0 -> startActivity(Intent(getActivity(), TwentiethCenturyGirl::class.java))
            1 -> startActivity(Intent(getActivity(), ACambodianNigthsDream::class.java))
            2 -> startActivity(Intent(getActivity(), Aftersun::class.java))
            3 -> startActivity(Intent(getActivity(), Autobiography::class.java))
            4 -> startActivity(Intent(getActivity(), BeforeNowThen::class.java))
            5 -> startActivity(Intent(getActivity(), Broker::class.java))
            6 -> startActivity(Intent(getActivity(), DecisionToLeave::class.java))
            7 -> startActivity(Intent(getActivity(), EEAAO::class.java))
            8 -> startActivity(Intent(getActivity(), HolySpider::class.java))
            9 -> startActivity(Intent(getActivity(), NextSohee::class.java))
            10 -> startActivity(Intent(getActivity(), ReturnToSeoul::class.java))
            11 -> startActivity(Intent(getActivity(), TheBansheesOfInisherin::class.java))
        }
    }
}