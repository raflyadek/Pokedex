package com.example.pokedex.repository

import com.example.pokedex.data.remote.PokeApi
import com.example.pokedex.data.remote.response.Pokemon
import com.example.pokedex.data.remote.response.PokemonList
import com.example.pokedex.util.Resource
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val api: PokeApi
){
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch(e: Exception) {
            return Resource.Error("Unknown error.")
        }
        return Resource.Success(response)
    }
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch(e: Exception) {
            return Resource.Error("Unknown error.")
        }
        return Resource.Success(response)
    }
}
