package by.ocheretny.lesson24

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val characters = ArrayList<Character>().apply {
        this.add(Character("Wraith","https://vgtimes.ru/uploads/gallery/main/170054/a2744a93d00b6a809df2a101fb3540e1.jpg",1500,2575,354))
        this.add(Character("Pathfinder","https://yandex-images.clstorage.net/t5o2PW197/5b5e5bROaPyO/M02vWD-KQqT-zZ0KFWz59vinS9iSeASSCvCFq3q_RnyQc-IgAHTCjYje34ZdQhyP2vR9vI8CXhh95X9xn3woGiPsW40rn8aE38n6H5VoWHJ98r6ok8mxBwuRcNs7m4LpxcViVAFwB4h9uE-WTVPufXjFms84ZCzKT0L-xN_J_d6CCXo73R5Ql-6sW_vED34HqgcZK7L9ZUM5Zlc4Wss23eJhIjGwopfqTyt6ICkUv78IhUnM68dsOv2APiWNy_-8ZMsIiSzb06XtzHrbR298BVkkybiTrFTiu3U0iHqqhf5j8pKBkpDk2OyKuxOKRI9uSDUqDaqmjTk_MV-mbbguzVWJmWhMOsOmb9w5mIdt3rR75_ro0vzXcUjWZxkZ2rTtw7JS0ZCjRpjdqQpxGoW9zDoG-l371X6pHoEuJvwrP72UeBtIPejwRE7fOJmkro62aFbJioL9x3MZlfTpG7i1TIJQMQDQ8oQJHOnowEkV72y7h7uPyqUu6o7hbWetuM7OFEurSD3ZwuadDkjJZL__1Zgnu_pjPoTQ2WZX60k6xE-wUsBCgyJ3Km9ayFJJFj6OC9drfuoEfru_Qy3kn2t_bCYqKshe-MJkTrwLmfVOjacbNLkY4WwVYwmkxEpL6UTdkZKgUNCgxNjvivki6yWdndv1W654N8zZHnBPNixrz72lebrI37hx9t_M2fumTk5FK7aZSmKcpTCKF2XJCat3_vLTs1DQAlco_xrp01g0fI775QiMKqc-Cn1ybhVvi5-_pqj4qv76YJaNLvqqJWy_5sjWyNnDPkYyqpc1ehk5da5g8sMhcnOXSD2r2_OKlryOaKTa_tmXPCkO8j_UvCnOv0e5mAoP2XO1jG5Iu7e9DIW7ltlYoU6nYdi1Bfp66PUdwrORYbETRLmO2fjz-TTfHlmnS3xaJ4z4z6AORk4aL0x2GGlJrGvy9--9uPu0PX90SjQJSYBclKD7h2fIQ",8,78,3))
        this.add(Character("Bloodhound","https://yandex-images.clstorage.net/t5o2PW197/5b5e5bA72S1a/Ajga-Ao6cnAOfLkKhXxJ94jm72hWDHQ3jvQgi05-4umg9SIlhcACvaie3_N9Jv3rCpL4_JqiC31ZsA-FyplYWhPdO7j_7-O1bul8-Tbf3wVLRVi6UY52k8uklZt6f3f9U2PmY4NBd2qs6pgweJRdPDmmiW379dx63qEv9c4LTL9XqbkIXBiTJEyt67j0r5_WSJb7-qE8tFMq9peZGJm1j-GSI-CxQhdLjGn4Mnpnfuyqh9hcWnfPGW6BTkbtit8P54uLe267MuV_DruIJe8vtYnXmhui_gUyqRbkSGmo9x4A8sLwssAHCM-p-pDLRb3f-saI38mEbEr_4j53_iqfz7eJuNkuihFUHZ56uoedHGXZhunoMt-1QymHd1kZaQacIIMQw1DhBAnOijnAyVYM7JiWic_L1S_ZD-Bcdl9rfaxmyekbv0tRtqzN6ugnHJ0kC7eZuHFP1QBo1uSoauk1LCCDIfHyMtV5nkoosaqmfZ7od0qMaBXceg2y3gdcWX9dJJo56Jw44pY-zek5xazN9PqXOOggfndA6-Q3GcjbVK2g4ADxcOFnOs7b2cPYJW6cCvUYHdvFHumssA2Hzni_PTbJu1tuuDKnTm_amtZ878QqBQtaQt9EIjlXN6kZWAc9oGFAQuJwF-isiNkAOhXsvFh26K2IRq1IL_JPtO0b_i42yRnInqiit7_cy3vFXP-XCFebqJG8RgMaFNf5G1vWf8JAAlOCIvXL_Qv78Zn2jO3L10pOimYtGJzi3ba9id9eR2toCP5qE4WfDmm7xc--RXqkq6qyz8ZS28d1qBu6xx9isSFAoSO1eeyZKkL6hcz8SrU6r9kUDygcgQw2DiueDAeoCNsP2WGmn33L2FX-vdT4JxsaYw6UY0k1Rknoi2buIRKTweNAZomsmqoxC3RuLFuUKJwYNz1KLrDMdl677Q9H6UjKv3jwRo5-OcpkXt12abSIuVCN5AHbleU7g",88,54,2))
        this.add(Character("Crypto","https://i.pinimg.com/originals/74/fc/4d/74fc4dac174d89ba087d8ab4579a6b06.png",2544,3775,88))
    }

    val selectedCharacter = MutableLiveData<Character>()

    fun sort(code:Int){
        when(code){
            0 -> characters.sortBy { it.name }
            1 -> characters.sortByDescending { it.countGames }
            2 -> characters.sortByDescending { it.countKills }
            3 -> characters.sortByDescending { it.countWins }
            4 -> characters.sortByDescending { it.winReit }
            5 -> characters.sortByDescending { it.kD }
        }
    }
}