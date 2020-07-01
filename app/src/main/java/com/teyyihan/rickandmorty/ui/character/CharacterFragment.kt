package com.teyyihan.rickandmorty.ui.character

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.app.SharedElementCallback
import androidx.navigation.fragment.navArgs
import androidx.transition.Fade
import com.bumptech.glide.RequestManager
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import com.teyyihan.rickandmorty.Consts
import com.teyyihan.rickandmorty.R
import com.teyyihan.rickandmorty.databinding.FragmentCharacterBinding
import com.teyyihan.rickandmorty.ui.main.QueryBottomSheet
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception
import javax.inject.Inject

@AndroidEntryPoint
class CharacterFragment : Fragment() {

    private lateinit var binding : FragmentCharacterBinding
    private val args: CharacterFragmentArgs by navArgs()
    @Inject
    lateinit var glide : RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform().setDuration(300)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)

        binding.root.transitionName = Consts.CHARACTER_CONTAINER_TRANSITION

        glide.load(args.character?._image).into(binding.characterFragmentImageview)
        binding.characterFragmentNameText.text = args.character?.name

        binding.characterFragmentStatusText.text = args.character?.status

        binding.characterFragmentSpeciesText.text = args.character?.species

        binding.characterFragmentGenderText.text = args.character?.gender

        binding.characterFragmentFromText.text = args.character?.origin?.name

        return binding.root
    }


}