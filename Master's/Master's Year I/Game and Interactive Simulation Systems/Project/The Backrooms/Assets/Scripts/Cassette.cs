using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Cassette : MonoBehaviour
{
    private void OnTriggerEnter(Collider other)
    {
        PlayerInventory playerInventory = other.GetComponent<PlayerInventory>();

        if(playerInventory != null)
        {
            playerInventory.VHSCollected();
            gameObject.SetActive(false);
        }
    }
}
