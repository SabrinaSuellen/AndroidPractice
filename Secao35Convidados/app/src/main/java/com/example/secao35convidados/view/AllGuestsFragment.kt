package com.example.secao35convidados.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.secao35convidados.R
import com.example.secao35convidados.service.constants.GuestConstants
import com.example.secao35convidados.view.adapter.GuestAdapter
import com.example.secao35convidados.view.listener.GuestListener
import com.example.secao35convidados.viewmodel.GuestsViewModel

class AllGuestsFragment : Fragment() {

    private lateinit var allGuestsViewModel: GuestsViewModel
    private val mAdapter: GuestAdapter = GuestAdapter()
    private lateinit var mListener: GuestListener


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        allGuestsViewModel = ViewModelProvider(this).get(GuestsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_all, container, false)

        val recycler = root.findViewById<RecyclerView>(R.id.recyclerview_all)

        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter

        mListener = object : GuestListener {
            override fun onClick(id: Int) {
                val intent = Intent(context, GuestFormActivity::class.java)

                val bundle = Bundle()
                bundle.putInt(GuestConstants.GUESTID, id)

                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDelete(id: Int) {
                allGuestsViewModel.delete(id)
                allGuestsViewModel.load(GuestConstants.FILTER.EMPTY)
            }

        }

        mAdapter.attachListener(mListener)
        observer()

        return root
    }

    override fun onResume() {
        super.onResume()
        allGuestsViewModel.load(GuestConstants.FILTER.EMPTY)
    }

    private fun observer() {
        allGuestsViewModel.guestList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuest(it)
        })
    }
}
