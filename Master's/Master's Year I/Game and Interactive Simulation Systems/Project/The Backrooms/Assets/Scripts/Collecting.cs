using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

public class Collecting : MonoBehaviour
{
    private TextMeshProUGUI textVHS;
    void Start()
    {
        textVHS = GetComponent<TextMeshProUGUI>();
    }

    public void updateVHSText(PlayerInventory playerInventory)
    {
        textVHS.text = playerInventory.NumberOfVHS.ToString() + "/7";
    }
}
