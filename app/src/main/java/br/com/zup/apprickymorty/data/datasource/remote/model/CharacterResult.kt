package br.com.zup.apprickymorty.data.datasource.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterResult(
    val name: String = "",
    val description: String = ""
): Parcelable
