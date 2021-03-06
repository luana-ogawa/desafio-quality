# desafio-quality
## Bootcamp Desafio Testing

> **Endpoint:** /house-valuation <p>
> **Method:** POST

**Payload exemplo:**

```
{
    "prop_name": "Casa Verde",
    "prop_district": "Bel Air",
    "rooms": [
        {
            "room_name": "Room 1",
            "room_width": 10.0,
            "room_length": 10.0
        },
        {
            "room_name": "Bathroom",
            "room_width": 5.0,
            "room_length": 5.0
        },
        {
            "room_name": "Kitchen",
            "room_width": 15.0,
            "room_length": 10.0
        }
    ]
}
```
    
**Saída esperada:**

```
{
    "totalArea": 275.0,
    "totalValue": 275000.0,
    "greatestRoom": {
        "room_name": "Kitchen",
        "room_width": 15.0,
        "room_length": 10.0
    },
    "roomSizes": [
        {
            "room_name": "Room 1",
            "room_size": 100.0
        },
        {
            "room_name": "Bathroom",
            "room_size": 25.0
        },
        {
            "room_name": "Kitchen",
            "room_size": 150.0
        }
    ]
}
```

**Bairros listados e seus valores:**

```
Bel Air - 1000.00
Beverly Hills - 2000.00
Silver Lake - 1500.00
Sun Valley - 1800.00
East Hollywood - 1900.00
Koreatown - 700.00
```
