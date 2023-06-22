export interface Tag {
  urlname: string;
  url: string;
}

export interface Item {
  name: string;
  tags: Tag[];
}

const items: Item[] = [
  {
    name: 'Cities',
    tags: [
      {
        urlname: 'Braga',
        url: 'https://www.google.com'
      },
      {
        urlname: 'Coimbra',
        url: 'https://www.google.com'
      },
      {
        urlname: 'Lisboa',
        url: 'https://www.google.com'
      },
      {
        urlname: 'Porto',
        url: 'https://www.google.com'
      }
    ]
  },
  {
    name: 'FAQs',
    tags: [
      {
        urlname: 'Do I need an account to make a reservation',
        url: 'https://www.google.com'
      },
      {
        urlname: 'How do I create an account',
        url: 'https://www.google.com'
      },
      {
        urlname: 'Can I cancel a reservation',
        url: 'https://www.google.com'
      }
    ]
  },
  {
    name: 'Policies',
    tags: [
      {
        urlname: 'Terms and Conditions',
        url: 'https://www.google.com'
      },
      {
        urlname: 'Privacy',
        url: 'https://www.google.com'
      },
      {
        urlname: 'Cookies',
        url: 'https://www.google.com'
      },
      {
        urlname: 'Legal Information',
        url: 'https://www.google.com'
      }]
  },
  {
    name: 'Contacts',
    tags: [
      {
        urlname: 'Contact1',
        url: 'https://www.google.com'
      },
      {
        urlname: 'Contact2',
        url: 'https://www.google.com'
      },
      {
        urlname: 'Contact3',
        url: 'https://www.google.com'
      },
      {
        urlname: 'Contact4',
        url: 'https://www.google.com'
      }]
  },
  {
    name: 'Follow Us',
    tags: [
      {
        urlname: 'Facebook',
        url: 'https://www.facebook.com'
      },
      {
        urlname: 'Linkedin',
        url: 'https://www.linkedin.com'
      },
      {
        urlname: 'Instagram',
        url: 'https://www.instagram.com'
      }
    ]
  }]

export default items
